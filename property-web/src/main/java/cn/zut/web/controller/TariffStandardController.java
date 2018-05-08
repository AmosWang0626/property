package cn.zut.web.controller;

import cn.zut.core.service.TariffStandardService;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author LiuBowen
 */
@RequestMapping("tariffStandard")
@Controller
public class TariffStandardController {

    @Resource
    private TariffStandardService tariffStandardService;

    /**
     * 设置水费
     */
    @RequestMapping("warterset")
    @ResponseBody
    public boolean warterSet(TariffStandardEntity tariffStandardEntity) {
        return tariffStandardService.waterSet(tariffStandardEntity);
    }

    /**
     * 设置网费
     */
    @RequestMapping("internetset")
    @ResponseBody
    public boolean internetSet(TariffStandardEntity tariffStandardEntity) {
        return tariffStandardService.internetSet(tariffStandardEntity);
    }

    /**
     * 设置电费
     */
    @RequestMapping("electricset")
    @ResponseBody
    public boolean electricSet(TariffStandardEntity tariffStandardEntity) {
        return tariffStandardService.electricSet(tariffStandardEntity);
    }

    /**
     * 设置电费
     */
    @RequestMapping("propertyset")
    @ResponseBody
    public boolean propertySet(TariffStandardEntity tariffStandardEntity) {
        return tariffStandardService.propertySet(tariffStandardEntity);
    }

    /**
     * 查看水费
     */
    @RequestMapping("getWater")
    @ResponseBody
    public TariffBillPlanEntity getWater(HttpServletRequest request) {
        HttpSession session = request.getSession();
        MemberEntity memberEntity = (MemberEntity) session.getAttribute("member");
        return tariffStandardService.getWater(memberEntity, "WATER");
    }
}
