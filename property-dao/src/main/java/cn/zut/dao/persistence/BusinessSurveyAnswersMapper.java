package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessSurveyAnswersEntity;

/**
 * @author LiuBowen
 * 本文件与 BusinessSurveyAnswersMapper.xml 相对应
 * 所有的接口都对应于 BusinessSurveyAnswersMapper.xml 中的 id
 * 例如: 下边的接口 insert 就对应 BusinessSurveyAnswersMapper.xml中的 <insert id="insert"></insert>
 */
public interface BusinessSurveyAnswersMapper extends
        Insert<BusinessSurveyAnswersEntity>,
        Update<BusinessSurveyAnswersEntity>,
        DeleteById<Integer>,
        SelectById<BusinessSurveyAnswersEntity, Integer>,
        SelectByExample<BusinessSurveyAnswersEntity, BusinessSurveyAnswersEntity>,
        SelectListByExample<BusinessSurveyAnswersEntity, BusinessSurveyAnswersEntity>,
        SelectCountByExample<BusinessSurveyAnswersEntity>,
        SelectListPageByExample<BusinessSurveyAnswersEntity, BusinessSurveyAnswersEntity> {
}