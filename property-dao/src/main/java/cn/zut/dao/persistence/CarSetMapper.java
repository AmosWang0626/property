package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.CarSetEntity;

public interface CarSetMapper extends
        Insert<CarSetEntity>,
        Update<CarSetEntity>,
        DeleteById<Integer>,
        SelectById<CarSetEntity, Integer>,
        SelectByExample<CarSetEntity, CarSetEntity>,
        SelectListByExample<CarSetEntity, CarSetEntity>,
        SelectCountByExample<CarSetEntity>,
        SelectListPageByExample<CarSetEntity, CarSetEntity> {
}