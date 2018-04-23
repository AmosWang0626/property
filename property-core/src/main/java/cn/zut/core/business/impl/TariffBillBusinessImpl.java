package cn.zut.core.business.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.util.DateUtil;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffConsumeEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffConsumeMapper;
import cn.zut.dao.persistence.TariffStandardMapper;
import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import cn.zut.facade.request.TariffBillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * PROJECT: property
 * DESCRIPTION: TariffBillBusiness
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Component("tariffBillBusiness")
public class TariffBillBusinessImpl implements TariffBillBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(TariffBillBusinessImpl.class);

    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffConsumeMapper tariffConsumeMapper;
    @Resource
    private TariffStandardMapper tariffStandardMapper;

    @Override
    public GenericResponse getUnitPrice(ConsumePreviewRequest consumePreviewRequest) {
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(consumePreviewRequest.getBusiness());
        tariffStandardEntity.setLevel(consumePreviewRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);
        if (tariffStandardEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        return new GenericResponse<>(tariffStandardEntity.getUnitPrice());
    }

    @Override
    public GenericResponse consumeConfirm(ConsumeConfirmRequest consumeConfirmRequest) {
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(consumeConfirmRequest.getBusiness());
        tariffStandardEntity.setLevel(consumeConfirmRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);

        if (tariffStandardEntity == null) {
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }
        TariffConsumeEntity tariffConsumeEntity = new TariffConsumeEntity();
        BeanUtils.copyProperties(consumeConfirmRequest, tariffConsumeEntity);
        tariffConsumeEntity.setConsumeAmount(tariffStandardEntity.getUnitPrice().multiply(consumeConfirmRequest.getUsedTotal()));
        tariffConsumeEntity.setStandardId(tariffStandardEntity.getStandardId());
        tariffConsumeEntity.setUnitPrice(tariffStandardEntity.getUnitPrice());
        tariffConsumeEntity.setCreateTime(new Date());
        tariffConsumeEntity.setUpdateTime(new Date());
        tariffConsumeMapper.insert(tariffConsumeEntity);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse generateMonthBill() {
        // 生成月度账单（物业费 / 水费 / 电费 / 网费）

        // 遍历房间: 拿到房间面积,计算物业费; 拿到水/电/网使用量,计算相应费用
        BigDecimal useTotal = new BigDecimal(new Random().nextInt(30) + 50);

        TariffBillRequest tariffBillRequest = new TariffBillRequest();
        // 房间号 || 业主编号
        tariffBillRequest.setHouseNo("1#101");
        tariffBillRequest.setMemberId(10000L);
        // 使用量(暂时随机)
        tariffBillRequest.setUsedTotal(useTotal);
        // 业务类型 + 业务等级
        tariffBillRequest.setBusiness(BusinessTypeEnum.PROPERTY);
        tariffBillRequest.setLevel(BusinessLevelEnum.PROPERTY_ONE);

        TariffBillEntity tariffBillEntity;
        try {
            tariffBillEntity = generateBill(tariffBillRequest);
        } catch (RuntimeException e) {
            LOGGER.error("当前资费标准不存在", e);
            return new GenericResponse(new ExceptionMessage(ExceptionCode.TARIFF_STANDARD_IS_NOT_EXIST));
        }

        tariffBillMapper.insert(tariffBillEntity);

        return GenericResponse.SUCCESS;
    }

    private TariffBillEntity generateBill(TariffBillRequest tariffBillRequest) throws RuntimeException {
        TariffBillEntity tariffBillEntity = new TariffBillEntity();

        // 房间号 || 业主用户编号 || 面积或使用量 || 业务类型 || 业务等级 || 备注
        tariffBillEntity.setHouseNo(tariffBillRequest.getHouseNo());
        tariffBillEntity.setMemberId(tariffBillRequest.getMemberId());
        tariffBillEntity.setUsedTotal(tariffBillRequest.getUsedTotal());
        tariffBillEntity.setBusiness(tariffBillRequest.getBusiness());
        tariffBillEntity.setLevel(tariffBillRequest.getLevel());
        tariffBillEntity.setExpand(tariffBillRequest.getExpand());

        // 由于标准是会变的,所以注意取其最新标准
        TariffStandardEntity tariffStandardEntity = new TariffStandardEntity();
        tariffStandardEntity.setBusiness(tariffBillRequest.getBusiness());
        tariffStandardEntity.setLevel(tariffBillRequest.getLevel());
        tariffStandardEntity = tariffStandardMapper.selectByExample(tariffStandardEntity);
        if (tariffStandardEntity == null) {
            throw new RuntimeException("当前资费标准不存在 "
                    + tariffBillRequest.getBusiness() + " ------ " + tariffBillRequest.getLevel());
        }
        tariffBillEntity.setStandardId(tariffStandardEntity.getStandardId());

        // 生成账单字段（本月生成上月账单）
        tariffBillEntity.setBillMonth(DateUtil.getMonth());
        tariffBillEntity.setBillStartDate(DateUtil.getPreMonthFirstDay());
        tariffBillEntity.setBillEndDate(DateUtil.getPreMonthLastDay());

        tariffBillEntity.setBillStatus(BillStatusEnum.REPAYING);
        tariffBillEntity.setUnitPrice(tariffStandardEntity.getUnitPrice());
        tariffBillEntity.setOverdueRate(tariffStandardEntity.getOverdueRate());
        tariffBillEntity.setBillAmount(tariffBillRequest.getUsedTotal().multiply(tariffStandardEntity.getUnitPrice()));
        tariffBillEntity.setCreateTime(new Date());

        return tariffBillEntity;
    }
}
