package cn.zut.core.business.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.common.util.DateUtil;
import cn.zut.core.business.PropertyJobBusiness;
import cn.zut.core.business.TariffBillBusiness;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.entity.TariffMonthConsumeEntity;
import cn.zut.dao.persistence.BusinessHouseRentMapper;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffBillPlanMapper;
import cn.zut.dao.persistence.TariffMonthConsumeMapper;
import cn.zut.facade.enums.BillStatusEnum;
import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.enums.HouseRentStatusEnum;
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
    private BusinessHouseRentMapper businessHouseRentMapper;
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

        List<TariffBillRequest> billRequests = new ArrayList<>();

        tariffMonthConsumeEntities.forEach(tariffMonthConsumeEntity -> {
            BusinessHouseRentEntity houseRentEntity = new BusinessHouseRentEntity();
            houseRentEntity.setHouseNo(tariffMonthConsumeEntity.getHouseNo());
            houseRentEntity.setRentStatus(HouseRentStatusEnum.RENT_ED);
            houseRentEntity = businessHouseRentMapper.selectByExample(houseRentEntity);
            if (houseRentEntity == null) {
                LOGGER.error("账单异常,租售房屋找不到,账单编号[{}], 房屋编号[{}]",
                        tariffMonthConsumeEntity.getId(),
                        tariffMonthConsumeEntity.getHouseNo());
                return;
            }
            String houseNo = houseRentEntity.getHouseNo();
            Long memberId = houseRentEntity.getMemberId();

            BigDecimal area = houseRentEntity.getArea();
            BigDecimal water = tariffMonthConsumeEntity.getWater();
            BigDecimal electric = tariffMonthConsumeEntity.getElectric();
            Boolean network = tariffMonthConsumeEntity.getNetwork();

            // 物业费
            if (BigDecimal.ZERO.compareTo(area) < 0) {
                TariffBillRequest tariffBillRequest = new TariffBillRequest();
                // 房间号 || 业主编号 || 使用量 || 业务类型 || 业务等级
                tariffBillRequest.setHouseNo(houseNo);
                tariffBillRequest.setMemberId(memberId);
                tariffBillRequest.setUsedTotal(area);
                // 业务类型 + 业务等级
                tariffBillRequest.setBusiness(BusinessTypeEnum.PROPERTY);
                tariffBillRequest.setLevel(BusinessLevelEnum.PROPERTY_ONE);

                billRequests.add(tariffBillRequest);
            }

            // 水费
            if (BigDecimal.ZERO.compareTo(water) < 0) {
                TariffBillRequest tariffBillRequest = new TariffBillRequest();
                // 房间号 || 业主编号 || 使用量 || 业务类型 || 业务等级
                tariffBillRequest.setHouseNo(houseNo);
                tariffBillRequest.setMemberId(memberId);
                tariffBillRequest.setUsedTotal(water);
                // 业务类型 + 业务等级
                tariffBillRequest.setBusiness(BusinessTypeEnum.WATER);
                tariffBillRequest.setLevel(BusinessLevelEnum.WATER_COMPANY);

                billRequests.add(tariffBillRequest);
            }

            // 电费
            if (BigDecimal.ZERO.compareTo(electric) < 0) {
                TariffBillRequest tariffBillRequest = new TariffBillRequest();
                // 房间号 || 业主编号 || 使用量 || 业务类型 || 业务等级
                tariffBillRequest.setHouseNo(houseNo);
                tariffBillRequest.setMemberId(memberId);
                tariffBillRequest.setUsedTotal(electric);
                // 业务类型 + 业务等级
                tariffBillRequest.setBusiness(BusinessTypeEnum.ELECTRICITY);
                tariffBillRequest.setLevel(BusinessLevelEnum.ELECTRICITY_COMPANY);

                billRequests.add(tariffBillRequest);
            }

            // 网费
            if (network != null && network) {
                TariffBillRequest tariffBillRequest = new TariffBillRequest();
                // 房间号 || 业主编号 || 使用量 || 业务类型 || 业务等级
                tariffBillRequest.setHouseNo(houseNo);
                tariffBillRequest.setMemberId(memberId);
                tariffBillRequest.setUsedTotal(new BigDecimal(1));
                // 业务类型 + 业务等级
                tariffBillRequest.setBusiness(BusinessTypeEnum.NETWORK);
                tariffBillRequest.setLevel(BusinessLevelEnum.NETWORK_COMPANY);

                billRequests.add(tariffBillRequest);
            }
        });

        List<TariffBillEntity> tariffBillEntities = generateBillList(billRequests);
        if (CollectionUtils.isEmpty(tariffBillEntities)) {
            return GenericResponse.SUCCESS;
        }

        tariffBillMapper.batchInsert(tariffBillEntities);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse generateBillPlan() {
        List<TariffBillPlanEntity> tariffBillPlanEntities = new ArrayList<>();

        List<TariffBillEntity> tariffBillEntities = tariffBillMapper.selectListByExample(null);
        for (TariffBillEntity tariffBillEntity : tariffBillEntities) {
            // 幂等性校验
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
            tariffBillPlanEntity.setRepayDate(DateUtil.getDateByMonthAndDay(tariffBillEntity.getBillMonth(), 15));

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
    public GenericResponse updateBillPlanStatus() {
        List<TariffBillPlanEntity> updateTariffBillPlanEntities = new ArrayList<>();
        List<TariffBillEntity> updateTariffBillEntities = new ArrayList<>();

        TariffBillPlanEntity search = new TariffBillPlanEntity();
        search.setBillStatus(BillStatusEnum.REPAYING);
        List<TariffBillPlanEntity> tariffBillPlanEntities = tariffBillPlanMapper.selectListByExample(search);
        tariffBillPlanEntities.forEach(tariffBillPlanEntity -> {
            Date repayDate = tariffBillPlanEntity.getRepayDate();
            Integer days = DateUtil.daysBetween(repayDate, new Date());
            if (days <= 0) {
                return;
            }
            // 计算逾期费
            Long billNo = tariffBillPlanEntity.getBillNo();
            TariffBillEntity tariffBillEntity = tariffBillMapper.selectById(billNo);
            tariffBillEntity.setBillStatus(BillStatusEnum.OVERDUE);
            tariffBillEntity.setUpdateTime(new Date());

            BigDecimal overdueRate = tariffBillEntity.getOverdueRate();
            BigDecimal billAmount = tariffBillPlanEntity.getBillAmount();
            BigDecimal overdueAmount = billAmount.multiply(overdueRate).multiply(BigDecimal.valueOf(days));
            tariffBillPlanEntity.setBillStatus(BillStatusEnum.OVERDUE);
            tariffBillPlanEntity.setOverdueDays(days);
            tariffBillPlanEntity.setLateChargeAmt(overdueAmount);
            tariffBillPlanEntity.setUpdateTime(new Date());

            updateTariffBillEntities.add(tariffBillEntity);
            updateTariffBillPlanEntities.add(tariffBillPlanEntity);
        });

        if (CollectionUtils.isEmpty(updateTariffBillEntities)
                || CollectionUtils.isEmpty(updateTariffBillPlanEntities)) {
            return GenericResponse.SUCCESS;
        }

        tariffBillMapper.batchUpdate(updateTariffBillEntities);
        tariffBillPlanMapper.batchUpdate(updateTariffBillPlanEntities);

        return GenericResponse.SUCCESS;
    }

    @Override
    public GenericResponse updateBillPlanAmount() {
        List<TariffBillPlanEntity> updateTariffBillPlanEntities = new ArrayList<>();

        TariffBillPlanEntity search = new TariffBillPlanEntity();
        search.setBillStatus(BillStatusEnum.OVERDUE);
        List<TariffBillPlanEntity> tariffBillPlanEntities = tariffBillPlanMapper.selectListByExample(search);
        tariffBillPlanEntities.forEach(tariffBillPlanEntity -> {
            Date repayDate = tariffBillPlanEntity.getRepayDate();
            Integer days = DateUtil.daysBetween(repayDate, new Date());
            if (days <= 0) {
                return;
            }
            // 计算逾期费
            Long billNo = tariffBillPlanEntity.getBillNo();
            TariffBillEntity tariffBillEntity = tariffBillMapper.selectById(billNo);
            BigDecimal overdueRate = tariffBillEntity.getOverdueRate();
            BigDecimal billAmount = tariffBillPlanEntity.getBillAmount();

            BigDecimal overdueAmount = billAmount.multiply(overdueRate).multiply(BigDecimal.valueOf(days));
            tariffBillPlanEntity.setOverdueDays(days);
            tariffBillPlanEntity.setLateChargeAmt(overdueAmount);
            tariffBillPlanEntity.setUpdateTime(new Date());

            updateTariffBillPlanEntities.add(tariffBillPlanEntity);
        });

        if (CollectionUtils.isEmpty(updateTariffBillPlanEntities)) {
            return GenericResponse.SUCCESS;
        }
        tariffBillPlanMapper.batchUpdate(updateTariffBillPlanEntities);

        return GenericResponse.SUCCESS;
    }

    /**
     * 根据请求表单生成账单
     *
     * @param tariffBillRequests TariffBillRequest
     * @return List<TariffBillEntity>
     */
    private List<TariffBillEntity> generateBillList(List<TariffBillRequest> tariffBillRequests) {
        List<TariffBillEntity> tariffBillEntities = new ArrayList<>();

        for (TariffBillRequest tariffBillRequest : tariffBillRequests) {
            try {
                TariffBillEntity tariffBillEntity = tariffBillBusiness.generateBill(tariffBillRequest);
                if (tariffBillEntity != null) {
                    tariffBillEntities.add(tariffBillEntity);
                }
            } catch (RuntimeException e) {
                LOGGER.error("当前资费标准不存在", e);
            }
        }

        return tariffBillEntities;
    }
}
