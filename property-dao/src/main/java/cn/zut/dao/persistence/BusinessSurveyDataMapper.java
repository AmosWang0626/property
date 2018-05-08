package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessSurveyDataEntity;

public interface BusinessSurveyDataMapper extends
        Insert<BusinessSurveyDataEntity>,
        Update<BusinessSurveyDataEntity>,
        DeleteById<Integer>,
        SelectById<BusinessSurveyDataEntity, Integer>,
        SelectByExample<BusinessSurveyDataEntity, BusinessSurveyDataEntity>,
        SelectListByExample<BusinessSurveyDataEntity, BusinessSurveyDataEntity>,
        SelectCountByExample<BusinessSurveyDataEntity>,
        SelectListPageByExample<BusinessSurveyDataEntity, BusinessSurveyDataEntity> {
}