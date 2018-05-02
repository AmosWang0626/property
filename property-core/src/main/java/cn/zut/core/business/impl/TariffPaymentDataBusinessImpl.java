package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.TariffPaymentDataBusiness;
import cn.zut.dao.entity.TariffCompanyBillEntity;
import cn.zut.dao.persistence.TariffCompanyBillMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/2
 */
@Component("tariffPaymentDataBusiness")
public class TariffPaymentDataBusinessImpl implements TariffPaymentDataBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(TariffPaymentDataBusinessImpl.class);

    @Resource
    private TariffCompanyBillMapper tariffCompanyBillMapper;

    @Override
    public SimplePageResult<TariffCompanyBillEntity> pagePaymentRecord(PageModel<TariffCompanyBillEntity> pageModel) {
        List<TariffCompanyBillEntity> tariffCompanyBillEntities = tariffCompanyBillMapper.selectListPageByExample(pageModel);
        int countByExample = tariffCompanyBillMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<TariffCompanyBillEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(countByExample);
        pageResult.setRows(tariffCompanyBillEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());

        return pageResult;
    }
}
