package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.dao.entity.ManageLogEntity;
import cn.zut.facade.request.EquipmentInfoRequest;

public interface LogBusiness {

    SimplePageResult<ManageLogEntity> pageMemberByModel(PageModel<ManageLogEntity> pageModel);


}
