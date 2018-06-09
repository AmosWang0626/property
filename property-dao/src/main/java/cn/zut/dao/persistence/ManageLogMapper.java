package cn.zut.dao.persistence;

import cn.zut.common.dao.Insert;
import cn.zut.common.dao.SelectCountByExample;
import cn.zut.common.dao.SelectListPageByExample;
import cn.zut.dao.entity.ManageLogEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author yangshangyu
 */
public interface ManageLogMapper extends Insert<ManageLogEntity>, 
        SelectCountByExample<ManageLogEntity>,
        SelectListPageByExample<ManageLogEntity, ManageLogEntity> {
        }
