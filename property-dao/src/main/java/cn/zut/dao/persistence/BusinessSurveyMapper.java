package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessSurveyEntity;

public interface BusinessSurveyMapper extends
        Insert<BusinessSurveyEntity>,
        Update<BusinessSurveyEntity>,
        DeleteById<Integer>,
        SelectById<BusinessSurveyEntity, Integer>,
        SelectByExample<BusinessSurveyEntity, BusinessSurveyEntity>,
        SelectListByExample<BusinessSurveyEntity, BusinessSurveyEntity>,
        SelectCountByExample<BusinessSurveyEntity>,
        SelectListPageByExample<BusinessSurveyEntity, BusinessSurveyEntity> {
}