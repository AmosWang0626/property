package cn.zut.common.to;

import java.io.Serializable;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/12/14
 * {"bank":"ICBC","validated":true,"cardType":"DC","key":"6217231702000816443","messages":[],"stat":"ok"}
 * {"validated":false,"key":"6228431888888688","stat":"ok","messages":[{"errorCodes":"CARD_BIN_NOT_MATCH","name":"cardNo"}]}
 *
 * @author DaoYuanWang
 */
public class CardInfoTo implements Serializable {

    private static final long serialVersionUID = -3733986900002420358L;

    /**
     * 银行缩写
     */
    private String bank;
    /**
     * 认证状态
     */
    private Boolean validated;
    /**
     * 银行卡类型
     * DC: "储蓄卡",
     * CC: "信用卡",
     * PC: "预付费卡"
     * SCC: "准贷记卡",
     */
    private String cardType;
    /**
     * 银行卡号
     */
    private String key;
    /**
     * 信息
     */
    private List<CardWarnTo> messages;
    /**
     * 状态 ok即正常
     */
    private String stat;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<CardWarnTo> getMessages() {
        return messages;
    }

    public void setMessages(List<CardWarnTo> messages) {
        this.messages = messages;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
