package cn.zut.core.business;

/**
 * PROJECT: property
 * DATE: 2017/12/14
 *
 * @author DaoYuanWang
 */
public interface HttpBusiness {

    /**
     * 获取银行卡名称
     *
     * @param bankNo 银行卡号
     * @return 银行卡名称
     */
    String getBankName(String bankNo);

}
