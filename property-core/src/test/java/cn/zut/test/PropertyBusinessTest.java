package cn.zut.test;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.persistence.BusinessHouseRentMapper;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.facade.enums.HouseRentStatusEnum;
import cn.zut.facade.enums.HouseTypeEnum;
import cn.zut.facade.response.MenuFirstLevelVO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jdbc.xml"})
public class PropertyBusinessTest {

    @Resource
    private BusinessHouseRentMapper businessHouseRentMapper;
    @Resource
    private BusinessRolesMapper businessRolesMapper;
    @Resource
    private BusinessMenusService businessMenusService;
    @Resource
    private BusinessRolesUserService businessRolesUserService;

    @Test
    public void addHouseRent() {
        BusinessHouseRentEntity businessHouseRentEntity = new BusinessHouseRentEntity();
        businessHouseRentEntity.setHouseNo("1131");
        businessHouseRentEntity.setName("居民住宅");
        businessHouseRentEntity.setCreateTime(new Date());
        businessHouseRentEntity.setAddress("中原西路146号");
        businessHouseRentEntity.setArea(new BigDecimal(129));
        businessHouseRentEntity.setRent(new BigDecimal(500));
        businessHouseRentEntity.setRentStatus(HouseRentStatusEnum.UN_RENT);
        businessHouseRentEntity.setType(HouseTypeEnum.HOUSE);
        businessHouseRentMapper.insert(businessHouseRentEntity);
    }

    /**
     * 测试下根据id查询
     */
    @Test
    public void getHouse() {
        BusinessHouseRentEntity businessHouseRentEntity = businessHouseRentMapper.selectById(3);
        System.out.println(businessHouseRentEntity);
    }

    /**
     * 测试下条件查询
     */
    @Test
    public void getHouseByExample() {
        BusinessHouseRentEntity businessHouseRentEntity = new BusinessHouseRentEntity();
//        businessHouseRentEntity.setHouseNo("1131");
//        businessHouseRentEntity.setType(HouseTypeEnum.HOUSE);
        businessHouseRentEntity.setRentStatus(HouseRentStatusEnum.UN_RENT);
        businessHouseRentEntity = businessHouseRentMapper.selectByExample(businessHouseRentEntity);
        System.out.println(businessHouseRentEntity);
    }


    @Test
    public void testMenus() {
        GenericResponse<List<MenuFirstLevelVO>> menus = businessRolesUserService.getMenus(10000L);
        System.out.println(JSON.toJSON(menus));
    }

    @Test
    public void getAllMenus() {
        List<BusinessMenusEntity> allMenus = businessMenusService.haveFatherIdMenus();
        System.out.println(JSON.toJSON(allMenus));
    }

    @Test
    public void getAllRole() {
        System.out.println(JSON.toJSON(businessRolesMapper.selectListByExample(null)));
    }

    /**
     * 测试下条件查询 [查询多条记录]
     */
    @Test
    public void getHouseListByExample() {
        BusinessHouseRentEntity businessHouseRentEntity = new BusinessHouseRentEntity();
//        businessHouseRentEntity.setHouseNo("1131");
//        businessHouseRentEntity.setType(HouseTypeEnum.HOUSE);
        businessHouseRentEntity.setRentStatus(HouseRentStatusEnum.UN_RENT);
        List<BusinessHouseRentEntity> businessHouseRentEntities = businessHouseRentMapper.selectListByExample(businessHouseRentEntity);
        System.out.println(businessHouseRentEntities);
    }

}
