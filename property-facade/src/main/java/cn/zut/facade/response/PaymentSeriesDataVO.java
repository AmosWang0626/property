package cn.zut.facade.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/6/7
 */
@Data
public class PaymentSeriesDataVO implements Serializable {

    private static final long serialVersionUID = 6600807840982437622L;

    private BigDecimal cash;
    private BigDecimal bankCard;
    private BigDecimal aliPay;
    private BigDecimal weChat;
}
