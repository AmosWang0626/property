package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.facade.response.PaymentSeriesDataVO;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/6/7
 */
public interface TariffStatisticsService {

    /**
     * 获取支付渠道数据
     *
     * @return GenericResponse
     */
    GenericResponse<PaymentSeriesDataVO> getPaymentWayData();

    /**
     * 获取账单数据
     *
     * @return GenericResponse
     */
    GenericResponse getBillData();
}
