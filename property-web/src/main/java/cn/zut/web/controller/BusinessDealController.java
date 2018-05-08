package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.dao.entity.TariffMonthConsumeEntity;
import cn.zut.dao.persistence.TariffMonthConsumeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("deal")
public class BusinessDealController {

    @Resource
    private TariffMonthConsumeMapper tariffMonthConsumeMapper;

    @RequestMapping("monthConsume")
    public GenericResponse monthConsume(HttpServletRequest request) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = new TariffMonthConsumeEntity();
        tariffMonthConsumeEntity.setMemberId(getMemberId(request));
        List<TariffMonthConsumeEntity> tariffMonthConsumeEntities = tariffMonthConsumeMapper.selectListByExample(tariffMonthConsumeEntity);

        return new GenericResponse<>(tariffMonthConsumeEntities);
    }

    @RequestMapping("pageConsume")
    public GenericResponse pageConsume(HttpServletRequest request) {
        TariffMonthConsumeEntity tariffMonthConsumeEntity = new TariffMonthConsumeEntity();
        tariffMonthConsumeEntity.setMemberId(getMemberId(request));
        List<TariffMonthConsumeEntity> tariffMonthConsumeEntities = tariffMonthConsumeMapper.selectListByExample(tariffMonthConsumeEntity);

        return new GenericResponse<>(tariffMonthConsumeEntities);
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }

}
