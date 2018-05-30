package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.core.business.EquipmentBusiness;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.dao.persistence.ManageEnterpriseMapper;
import cn.zut.dao.persistence.ManageEquipmentMapper;
import cn.zut.facade.request.EnterpriseInfoRequest;
import cn.zut.facade.request.EquipmentInfoRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("equipmentBusiness")
public class EquipmentBusinessImpl implements EquipmentBusiness {
    @Resource
    private ManageEquipmentMapper manageEquipmentMapper;
    @Override
    public SimplePageResult<ManageEquipmentEntity> pageMemberByModel(PageModel<ManageEquipmentEntity> pageModel) {
        List<ManageEquipmentEntity> applyEntities = manageEquipmentMapper.selectListPageByExample(pageModel);
        int memberCount = manageEquipmentMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<ManageEquipmentEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(memberCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

    @Override
    public GenericResponse equipmentInfo(EquipmentInfoRequest equipmentInfoRequest) {
        return null;
    }

    @Override
    public GenericResponse deleteEquipment(EquipmentInfoRequest equipmentInfoRequest) {
        return null;
    }
}
