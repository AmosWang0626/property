package cn.zut.facade.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/17
 */
@Data
public class TariffMonthConsumeConfirmRequest {

    /**
     * 房屋编号
     */
    @NotEmpty(message = "房屋编号不能为空")
    private String houseNo;
    /**
     * 月度用水量
     */
    @NotNull(message = "月度用水量不能为空")
    private BigDecimal water;
    /**
     * 月度用电量
     */
    @NotNull(message = "月度用电量不能为空")
    private BigDecimal electric;
    /**
     * 网络是否开启
     */
    @NotNull(message = "网络是否开启不能为空")
    private Boolean network;
    /**
     * 操作人
     */
    @NotEmpty(message = "操作人不能为空")
    private String operator;
    /**
     * 拓展字段
     */
    private String expand;

}
