package cn.zut.core.business.impl;

import cn.zut.common.check.GeneralCheck;
import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.common.security.DesEncryptionUtil;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.EncryptUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.business.CarBusiness;
import cn.zut.core.business.MemberBusiness;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.MemberService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.BusinessCarSetMapper;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.request.*;
import cn.zut.facade.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author Liubowen
 */
@Component("carBusiness")
public class CarBusinessImpl implements CarBusiness {

    @Resource
    private BusinessCarSetMapper businessCarSetMapper;


    @Transactional(rollbackFor = Exception.class)

    @Override
    public SimplePageResult<BusinessCarSetEntity> pageMemberByModel(PageModel<BusinessCarSetEntity> pageModel) {
        List<BusinessCarSetEntity> applyEntities = businessCarSetMapper.selectListPageByExample(pageModel);
        int carCount = businessCarSetMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<BusinessCarSetEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(carCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

}
