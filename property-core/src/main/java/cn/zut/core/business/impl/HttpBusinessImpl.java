package cn.zut.core.business.impl;

import cn.zut.common.api.HttpApi;
import cn.zut.common.to.CardInfoTo;
import cn.zut.common.to.CardWarnTo;
import cn.zut.core.business.HttpBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     https://ab.alipay.com/i/yinhang.htm
 * </p>
 * PROJECT: property
 * DATE: 2017/12/14
 *
 * @author DaoYuanWang
 */
@Component
public class HttpBusinessImpl implements HttpBusiness {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpBusinessImpl.class);

    /**
     * 错误码
     * 非法参数 && 银行卡Bin不匹配
     */
    private static final String PARAM_ILLEGAL = "PARAM_ILLEGAL";
    private static final String CARD_BIN_NOT_MATCH = "CARD_BIN_NOT_MATCH";

    /**
     * api
     */
    private HttpApi httpApi;
    private static Map<String, String> alterMap = null;

    public HttpBusinessImpl() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpApi.ALI_CCD_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        this.httpApi = retrofit.create(HttpApi.class);
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        alterMap = new HashMap<>(4);
        // 交通银行 api | self
        alterMap.put("COMM", "BCM");
        // 北京银行 api | self
        alterMap.put("BJBANK", "BCCB");
        // 平安银行 api / self
        alterMap.put("SPABANK", "SZPA");
        // 中信银行 api | self
        alterMap.put("CITIC", "ECITIC");
    }

    @Override
    public String getBankName(String bankNo) {
        Call<CardInfoTo> bankTo = httpApi.getBankTo(bankNo);
        Response<CardInfoTo> response = null;
        try {
            response = bankTo.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response == null || response.body() == null) {
            return null;
        }
        if (response.isSuccess() && response.body().getBank() != null) {
            return alterByBankName(response.body().getBank());
        }
        CardWarnTo cardWarnTo = response.body().getMessages().get(0);
        String errorCodes = cardWarnTo.getErrorCodes();
        if (PARAM_ILLEGAL.equals(errorCodes) || CARD_BIN_NOT_MATCH.equals(errorCodes)) {
            errorCodes = "银行卡号不存在或输入有误,请检查后重新输入";
        }
        LOGGER.error("错误类型:[{}] && 错误原因:[{}]", cardWarnTo.getName(), errorCodes);
        return null;
    }

    /**
     * api返回的银行缩写较老,修改成我们的名字
     *
     * @param bankName 银行名字缩写
     * @return 如果有修改修改后的名字, 没有就是传进来的名字
     */
    private String alterByBankName(String bankName) {
        for (String key : alterMap.keySet()) {
            if (key.equals(bankName)) {
                bankName = alterMap.get(key);
            }
        }
        return bankName;
    }

    public static void main(String[] args) {
        System.out.println(new HttpBusinessImpl().alterByBankName("CITIC"));
    }
}
