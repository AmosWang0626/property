package cn.zut.facade.enums;

import cn.zut.facade.api.ComboVO;
import cn.zut.facade.api.Mapping;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum PaymentWayEnum implements Mapping<String, String> {

    /**
     * 支付方式
     */
    ALI_PAY("支付宝"),
    WE_CHAT("微信"),
    BANK_CARD("银行卡"),
    CASH("现金"),;

    private final String value;

    PaymentWayEnum(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return value;
    }

    /**
     * 传入字符串返回匹配枚举, 使用者要对null进行处理
     *
     * @param value 字符串key
     * @return this
     */
    public PaymentWayEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (PaymentWayEnum paymentWayEnum : PaymentWayEnum.values()) {
            if (paymentWayEnum.getKey().equals(value)) {
                return paymentWayEnum;
            }
        }
        return null;
    }

    public List<ComboVO> getPaymentWayList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(ALI_PAY));
        comboVOList.add(new ComboVO<>(WE_CHAT));
        comboVOList.add(new ComboVO<>(BANK_CARD));
        return comboVOList;
    }
}
