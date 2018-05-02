package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.TariffCompanyBillEntity;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/2
 */
public interface TariffPaymentDataBusiness {

    /**
     * 缴费账单分页数据
     *
     * @param pageModel 分页查询对象
     * @return GenericResponse
     */
    SimplePageResult<TariffCompanyBillEntity> pagePaymentRecord(PageModel<TariffCompanyBillEntity> pageModel);
}
