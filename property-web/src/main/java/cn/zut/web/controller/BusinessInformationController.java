package cn.zut.web.controller;

import cn.zut.core.service.TariffMothConsumeService;
import cn.zut.dao.entity.TariffMonthConsumeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("information")
public class BusinessInformationController {

    @Resource
    private TariffMothConsumeService tariffMothConsumeService;

    @RequestMapping("users")
    @ResponseBody
    public Map<String, Object> sendAllUsers() {
        List<TariffMonthConsumeEntity> list = tariffMothConsumeService.getAllUsers();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        resultMap.put("msg", "");
        resultMap.put("code", "0");
        return resultMap;
    }

    @RequestMapping("updateByWater")
    @ResponseBody
    public boolean updateByWater(Integer memberId, BigDecimal water) {
        return tariffMothConsumeService.updateByWater(memberId, water);
    }

    @RequestMapping("updateByElectric")
    @ResponseBody
    public boolean updateByElectric(Integer memberId, BigDecimal electric) {
        return tariffMothConsumeService.updateByElectric(memberId, electric);
    }

    @RequestMapping("updateByProperty")
    @ResponseBody
    public boolean updateByProperty(Integer memberId, BigDecimal property) {
        return tariffMothConsumeService.updateByProperty(memberId, property);
    }

    @RequestMapping("updateByInternet")
    @ResponseBody
    public boolean updateByInternet(Integer memberId, Boolean internet) {
        return tariffMothConsumeService.updateByInternet(memberId, internet);
    }
}
