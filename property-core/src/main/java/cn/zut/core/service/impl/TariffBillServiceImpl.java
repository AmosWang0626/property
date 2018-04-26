package cn.zut.core.service.impl;

import cn.zut.core.service.TariffBillService;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffBillPlanMapper;
import cn.zut.facade.enums.BillStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/26
 */
@Service("tariffBillService")
public class TariffBillServiceImpl implements TariffBillService {
    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffBillPlanMapper tariffBillPlanMapper;

    /**
     * 两个或者多个数据库操作一定要加上事务回滚
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void billOffset(TariffBillEntity tariffBillEntity, TariffBillPlanEntity tariffBillPlanEntity, BigDecimal paymentAmount) {
        // 全额还款 [先冲罚息,再冲本金] (目前仅支持全额结清)
        if (paymentAmount.compareTo(tariffBillPlanEntity.getTotalRepayAmount()) == 0) {
            BigDecimal paymentLateCharge = paymentAmount.subtract(tariffBillPlanEntity.getSumLateCharge());

            if (BigDecimal.ZERO.compareTo(paymentLateCharge.subtract(tariffBillPlanEntity.getSumBillAmount())) != 0) {
                throw new RuntimeException("账单异常");
            }

            tariffBillPlanEntity.setLateChargeAmtPaid(tariffBillPlanEntity.getSumLateCharge());
            tariffBillPlanEntity.setBillAmountPaid(paymentLateCharge);

            if (tariffBillPlanEntity.repayFinished()) {
                tariffBillPlanEntity.setBillStatus(BillStatusEnum.SETTLE);
                tariffBillPlanEntity.setSettleDate(new Date());
                tariffBillPlanEntity.setUpdateTime(new Date());
                tariffBillPlanMapper.update(tariffBillPlanEntity);

                tariffBillEntity.setBillStatus(BillStatusEnum.SETTLE);
                tariffBillEntity.setUpdateTime(new Date());
                tariffBillMapper.update(tariffBillEntity);
            }
        }
    }
}
