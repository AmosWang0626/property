package cn.zut.core.service.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.common.util.DateUtil;
import cn.zut.core.service.TariffStatisticsService;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffCompanyBillEntity;
import cn.zut.dao.entity.TariffConsumeEntity;
import cn.zut.dao.persistence.TariffBillMapper;
import cn.zut.dao.persistence.TariffCompanyBillMapper;
import cn.zut.dao.persistence.TariffConsumeMapper;
import cn.zut.facade.enums.BusinessTypeEnum;
import cn.zut.facade.response.BusinessSeriesDataVO;
import cn.zut.facade.response.PaymentSeriesDataVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/6/7
 */
@Component("tariffStatisticsService")
public class TariffStatisticsServiceImpl implements TariffStatisticsService {

    @Resource
    private TariffBillMapper tariffBillMapper;
    @Resource
    private TariffConsumeMapper tariffConsumeMapper;
    @Resource
    private TariffCompanyBillMapper tariffCompanyBillMapper;

    @Override
    public GenericResponse<PaymentSeriesDataVO> getPaymentWayData() {
        List<TariffCompanyBillEntity> tariffCompanyBillEntities = tariffCompanyBillMapper.totalAmountByPaymentWay();

        PaymentSeriesDataVO paymentSeriesDataVO = new PaymentSeriesDataVO();

        tariffCompanyBillEntities.forEach(tariffCompanyBillEntity -> {
            if (tariffCompanyBillEntity.getPaymentWay() != null) {
                switch (tariffCompanyBillEntity.getPaymentWay()) {
                    case CASH:
                        paymentSeriesDataVO.setCash(tariffCompanyBillEntity.getPaymentAmount());
                        break;
                    case ALI_PAY:
                        paymentSeriesDataVO.setAliPay(tariffCompanyBillEntity.getPaymentAmount());
                        break;
                    case BANK_CARD:
                        paymentSeriesDataVO.setBankCard(tariffCompanyBillEntity.getPaymentAmount());
                        break;
                    case WE_CHAT:
                        paymentSeriesDataVO.setWeChat(tariffCompanyBillEntity.getPaymentAmount());
                        break;
                    default:
                        break;
                }
            }
        });

        return new GenericResponse<>(paymentSeriesDataVO);
    }

    @Override
    public GenericResponse getBillData() {
        BusinessSeriesDataVO businessSeriesDataVO = new BusinessSeriesDataVO();
        businessSeriesDataVO.init();

        Calendar ca = Calendar.getInstance();
        String nowMonth = DateUtil.FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
        ca.add(Calendar.MONTH, -1);
        String preMonth = DateUtil.FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
        ca.add(Calendar.MONTH, -1);
        String pre2Month = DateUtil.FORMAT_YEAR_2_MONTH.get().format(ca.getTime());
        ca.add(Calendar.MONTH, -1);
        String pre3Month = DateUtil.FORMAT_YEAR_2_MONTH.get().format(ca.getTime());

        businessSeriesDataVO = getBusinessSeriesDataVO(businessSeriesDataVO, pre3Month, 1);
        businessSeriesDataVO = getBusinessSeriesDataVO(businessSeriesDataVO, pre2Month, 2);
        businessSeriesDataVO = getBusinessSeriesDataVO(businessSeriesDataVO, preMonth, 3);
        businessSeriesDataVO = getBusinessSeriesDataVO(businessSeriesDataVO, nowMonth, 4);

        return new GenericResponse<>(businessSeriesDataVO);
    }

    private BusinessSeriesDataVO getBusinessSeriesDataVO(BusinessSeriesDataVO businessSeriesDataVO, String month, int size) {
        businessSeriesDataVO.getMonth().add(month);
        List<TariffBillEntity> tariffBillEntities = tariffBillMapper.totalAmountByMonth(month);
        for (TariffBillEntity tariffBillEntity : tariffBillEntities) {
            if (BusinessTypeEnum.WATER.equals(tariffBillEntity.getBusiness())) {
                businessSeriesDataVO.getWater().add(tariffBillEntity.getBillAmount());
            } else if (BusinessTypeEnum.ELECTRICITY.equals(tariffBillEntity.getBusiness())) {
                businessSeriesDataVO.getElectricity().add(tariffBillEntity.getBillAmount());
            } else if (BusinessTypeEnum.NETWORK.equals(tariffBillEntity.getBusiness())) {
                businessSeriesDataVO.getNetwork().add(tariffBillEntity.getBillAmount());
            } else if (BusinessTypeEnum.PROPERTY.equals(tariffBillEntity.getBusiness())) {
                businessSeriesDataVO.getProperty().add(tariffBillEntity.getBillAmount());
            }
        }
        List<TariffConsumeEntity> tariffConsumeEntities = tariffConsumeMapper.totalAmountByMonth(month);
        for (TariffConsumeEntity tariffConsumeEntity : tariffConsumeEntities) {
            if (BusinessTypeEnum.SITE.equals(tariffConsumeEntity.getBusiness())) {
                businessSeriesDataVO.getSite().add(tariffConsumeEntity.getConsumeAmount());
            } else if (BusinessTypeEnum.PARKING.equals(tariffConsumeEntity.getBusiness())) {
                businessSeriesDataVO.getParking().add(tariffConsumeEntity.getConsumeAmount());
            }
        }

        businessSeriesDataVO = notNull(businessSeriesDataVO, size);
        return businessSeriesDataVO;
    }

    private BusinessSeriesDataVO notNull(BusinessSeriesDataVO businessSeriesDataVO, int size) {
        if (businessSeriesDataVO.getWater().size() != size) {
            businessSeriesDataVO.getWater().add(BigDecimal.ZERO);
        }
        if (businessSeriesDataVO.getElectricity().size() != size) {
            businessSeriesDataVO.getElectricity().add(BigDecimal.ZERO);
        }
        if (businessSeriesDataVO.getNetwork().size() != size) {
            businessSeriesDataVO.getNetwork().add(BigDecimal.ZERO);
        }
        if (businessSeriesDataVO.getProperty().size() != size) {
            businessSeriesDataVO.getProperty().add(BigDecimal.ZERO);
        }
        if (businessSeriesDataVO.getParking().size() != size) {
            businessSeriesDataVO.getParking().add(BigDecimal.ZERO);
        }
        if (businessSeriesDataVO.getSite().size() != size) {
            businessSeriesDataVO.getSite().add(BigDecimal.ZERO);
        }

        return businessSeriesDataVO;
    }
}
