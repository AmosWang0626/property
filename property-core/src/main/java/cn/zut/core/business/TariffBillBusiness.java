package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.TariffBillEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.facade.request.ConsumeConfirmRequest;
import cn.zut.facade.request.ConsumePreviewRequest;
import cn.zut.facade.request.TariffBillRequest;

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
     * @param operatorMemberId      操作人用户编号
     * @param consumeConfirmRequest 直接消费表单
     * @return 通用返回结果
     */
    GenericResponse consumeConfirm(Long operatorMemberId, ConsumeConfirmRequest consumeConfirmRequest);

    /**
     * 生成月度账单
     *
     * @return GenericResponse
     */
    GenericResponse generateMonthBill();

    /**
     * 手动录入账单
     *
     * @param operatorMemberId  操作人用户编号
     * @param tariffBillRequest 录入账单表单
     * @return 通用返回结果
     */
    GenericResponse billEntry(Long operatorMemberId, TariffBillRequest tariffBillRequest);

    /**
     * 查询所有账单
     *
     * @param pageModel 分页查询对象
     * @return GenericResponse
     */
    SimplePageResult<TariffBillEntity> pageBillByModel(PageModel<TariffBillEntity> pageModel);

    /**
     * 查询所有账单计划
     *
     * @param pageModel 分页查询对象
     * @return GenericResponse
     */
    SimplePageResult<TariffBillPlanEntity> pageBillPlanByModel(PageModel<TariffBillPlanEntity> pageModel);
}
