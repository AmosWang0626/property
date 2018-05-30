package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.facade.request.EnterpriseInfoRequest;
import cn.zut.facade.request.EquipmentInfoRequest;

public interface EquipmentBusiness {

    SimplePageResult<ManageEquipmentEntity> pageMemberByModel(PageModel<ManageEquipmentEntity> pageModel);

    /**
     * 修改设备数量
     *
     * @param equipmentInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse equipmentInfo(EquipmentInfoRequest equipmentInfoRequest);

    /**
     * 删除设备信息
     *
     * @param equipmentInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse deleteEquipment(EquipmentInfoRequest equipmentInfoRequest);
}
