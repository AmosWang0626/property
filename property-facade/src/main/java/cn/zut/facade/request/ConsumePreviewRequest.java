package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessLevelEnum;
import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/17
 */
@Data
public class ConsumePreviewRequest {
    /**
     * 业务类型
     */
    @NotNull(message = "业务类型不能为空")
    private BusinessTypeEnum business;
    /**
     * 缴费标准等级
     */
    @NotNull(message = "业务标准等级不能为空")
    private BusinessLevelEnum level;
}
