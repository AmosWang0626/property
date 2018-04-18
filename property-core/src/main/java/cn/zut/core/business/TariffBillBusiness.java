package cn.zut.core.business;

import cn.zut.common.generic.GenericResponse;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;

/**
 * PROJECT: property
 * DESCRIPTION: TariffBillBusiness
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
public interface TariffBillBusiness {

    /**
     * 消费预览单价
     * <p>
     * 必传: {业务类型: business, 业务等级: level}
     *
     * @param consumePreviewRequest 直接消费表单
     * @return 通用返回结果
     */
    GenericResponse getUnitPrice(ConsumePreviewRequest consumePreviewRequest);

    /**
     * 直接消费调用
     *
     * @param consumeConfirmRequest 直接消费表单
     * @return 通用返回结果
     */
    GenericResponse consumeConfirm(ConsumeConfirmRequest consumeConfirmRequest);

    /**
     * 生成月度账单
     *
     * @return GenericResponse
     */
    GenericResponse generateMonthBill();
}
