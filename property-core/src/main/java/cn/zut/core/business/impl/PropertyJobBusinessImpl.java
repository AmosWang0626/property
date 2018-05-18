package cn.zut.core.business.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.util.DateUtil;
import cn.zut.core.business.PropertyJobBusiness;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.entity.TariffMonthConsumeEntity;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffBillPlanMapper;
import cn.zut.dao.persistence.TariffMonthConsumeMapper;
import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.request.TariffBillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/18
 */
@Component("propertyJobBusiness")
public class PropertyJobBusinessImpl implements PropertyJobBusiness {

    private static Logger LOGGER = LoggerFactory.getLogger(PropertyJobBusinessImpl.class);

    @Resource
    private TariffBillBusiness tariffBillBusiness;
    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffMonthConsumeMapper tariffMonthConsumeMapper;
    @Resource
    private TariffBillPlanMapper tariffBillPlanMapper;

    /**
     * 生成月度账单（物业费 / 水费 / 电费 / 网费）
     */
    @Override
    public GenericResponse generateMonthBill() {
        // 遍历房间: 拿到房间面积,计算物业费; 拿到水/电/网使用量,计算相应费用
        TariffMonthConsumeEntity search = new TariffMonthConsumeEntity();
        search.setMonth(DateUtil.getPreMonth());
        List<TariffMonthConsumeEntity> tariffMonthConsumeEntities = tariffMonthConsumeMapper.selectListByExample(search);

        TariffBillRequest tariffBillRequest = new TariffBillRequest();
        // 房间号 || 业主编号
        tariffBillRequest.setHouseNo("1#101");
        tariffBillRequest.setMemberId(10000L);
        // 使用量(暂时随机)
//        tariffBillRequest.setUsedTotal(useTotal);
        // 业务类型 + 业务等级
        tariffBillRequest.setBusiness(BusinessTypeEnum.PROPERTY);
        tariffBillRequest.setLevel(BusinessLevelEnum.PROPERTY_ONE);

        TariffBillEntity tariffBillEntity;
        try {
            tariffBillEntity = tariffBillBusiness.generateBill(tariffBillRequest);
        } catch (RuntimeException e) {
            LOGGER.error("当前资费标准不存在", e);
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        tariffBillMapper.insert(tariffBillEntity);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse generateBillPlan() {
        List<TariffBillPlanEntity> tariffBillPlanEntities = new ArrayList<>();

        List<TariffBillEntity> tariffBillEntities = tariffBillMapper.selectListByExample(null);
        for (TariffBillEntity tariffBillEntity : tariffBillEntities) {
            TariffBillPlanEntity tariffBillPlanEntity = new TariffBillPlanEntity();
            tariffBillPlanEntity.setBillNo(tariffBillEntity.getBillNo());
            tariffBillPlanEntity = tariffBillPlanMapper.selectByExample(tariffBillPlanEntity);
            if (tariffBillPlanEntity != null) {
                continue;
            }

            tariffBillPlanEntity = new TariffBillPlanEntity();

            tariffBillPlanEntity.setBillNo(tariffBillEntity.getBillNo());
            tariffBillPlanEntity.setMemberId(tariffBillEntity.getMemberId());
            tariffBillPlanEntity.setBillStatus(tariffBillEntity.getBillStatus());
            tariffBillPlanEntity.setBillAmount(tariffBillEntity.getBillAmount());
            // 获取应还日期 每月10日
            tariffBillPlanEntity.setRepayDate(DateUtil.getDateByMonthAndDay(tariffBillEntity.getBillMonth(), 10));

            // 账单逾期天数 || 初始化逾期/减免金额
            tariffBillPlanEntity.setOverdueDays(0);
            tariffBillPlanEntity.setBillAmountPaid(BigDecimal.ZERO);
            tariffBillPlanEntity.setBillAmountOffer(BigDecimal.ZERO);
            tariffBillPlanEntity.setLateChargeAmt(BigDecimal.ZERO);
            tariffBillPlanEntity.setLateChargeAmtPaid(BigDecimal.ZERO);
            tariffBillPlanEntity.setLateChargeAmtOffer(BigDecimal.ZERO);
            tariffBillPlanEntity.setCreateTime(new Date());

            tariffBillPlanEntities.add(tariffBillPlanEntity);
        }
        if (CollectionUtils.isEmpty(tariffBillPlanEntities)) {
            return GenericResponse.SUCCESS;
        }
        tariffBillPlanMapper.batchInsert(tariffBillPlanEntities);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse updateBillPlan2OverDue() {

        return null;
    }

    @Override
    public GenericResponse updateOverDueBillPlan() {
        TariffBillPlanEntity search = new TariffBillPlanEntity();
        search.setBillStatus(BillStatusEnum.OVERDUE);
        List<TariffBillPlanEntity> tariffBillPlanEntities = tariffBillPlanMapper.selectListByExample(search);
        tariffBillPlanEntities.forEach(tariffBillPlanEntity -> {
            Date repayDate = tariffBillPlanEntity.getRepayDate();
            int days = DateUtil.daysBetween(repayDate, new Date());

        });

        return GenericResponse.SUCCESS;
    }
}
