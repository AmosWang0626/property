package cn.zut.common.api;

import cn.zut.common.to.CardInfoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * PROJECT: property
 * DATE: 2017/12/14
 *
 * @author DaoYuanWang
 */
public interface HttpApi {

    String ALI_CCD_API = "https://ccdcapi.alipay.com/";

    /**
     * 根据银行卡号获取银行卡信息
     * https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=***&cardBinCheck=true
     *
     * @param bankNo 银行卡号
     * @return Api Trans Data
     */
    @GET("validateAndCacheCardInfo.json?_input_charset=utf-8&cardBinCheck=true")
    Call<CardInfoDTO> getBankTo(@Query("cardNo") String bankNo);

}
