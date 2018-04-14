package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.TariffCompanyEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.facade.request.TariffCompanyRequest;
import cn.zut.facade.request.TariffStandardRequest;

/**
 * PROJECT: property
 * DESCRIPTION: 资费管理业务
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
public interface TariffStaticBusiness {

    /**
     * 添加公司
     *
     * @param tariffCompanyRequest 公司表单
     * @return GenericResponse
     */
    GenericResponse addCompany(TariffCompanyRequest tariffCompanyRequest);

    /**
     * 修改公司信息
     *
     * @param tariffCompanyRequest 公司表单
     * @return GenericResponse
     */
    GenericResponse modifyCompany(TariffCompanyRequest tariffCompanyRequest);

    /**
     * 获取指定公司信息
     *
     * @param tariffCompanyRequest 公司表单
     * @return GenericResponse
     */
    GenericResponse getCompany(TariffCompanyRequest tariffCompanyRequest);

    /**
     * 获取指定公司信息 List
     *
     * @param tariffCompanyRequest 公司表单
     * @return GenericResponse
     */
    GenericResponse getCompanyList(TariffCompanyRequest tariffCompanyRequest);

    /**
     * 注销指定公司信息
     *
     * @param companyId 公司编号
     * @return GenericResponse
     */
    GenericResponse removeCompany(Long companyId);

    /**
     * 制定标准
     *
     * @param tariffStandardRequest 标准表单
     * @return GenericResponse
     */
    GenericResponse addStandard(TariffStandardRequest tariffStandardRequest);

    /**
     * 修改标准
     *
     * @param tariffStandardRequest 标准表单
     * @return GenericResponse
     */
    GenericResponse modifyStandard(TariffStandardRequest tariffStandardRequest);

    /**
     * 获取指定标准信息
     *
     * @param tariffStandardRequest 标准表单
     * @return GenericResponse
     */
    GenericResponse getStandard(TariffStandardRequest tariffStandardRequest);

    /**
     * 获取指定标准信息 List
     *
     * @param tariffStandardRequest 标准表单
     * @return GenericResponse
     */
    GenericResponse getStandardList(TariffStandardRequest tariffStandardRequest);

    /**
     * 移除指定标准
     *
     * @param standardId 标准id
     * @return GenericResponse
     */
    GenericResponse removeStandard(Long standardId);

    /**
     * 公司管理
     *
     * @param pageModel 分页查询对象
     * @return GenericResponse
     */
    SimplePageResult<TariffCompanyEntity> pageCompanyByModel(PageModel<TariffCompanyEntity> pageModel);

    /**
     * 标准管理
     *
     * @param pageModel 分页查询对象
     * @return GenericResponse
     */
    SimplePageResult<TariffStandardEntity> pageStandardByModel(PageModel<TariffStandardEntity> pageModel);
}
