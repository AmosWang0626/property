package cn.zut.test;

import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.facade.enums.SystemRolesEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: property2
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jdbc.xml"})
public class PropertyInitTest {

    @Resource
    private BusinessRolesMapper businessRolesMapper;

    @Test
    public void initRoles() {
        List<BusinessRolesEntity> list = new ArrayList<>();
        for (SystemRolesEnum rolesEnum : SystemRolesEnum.values()) {
            BusinessRolesEntity businessRolesEntity = new BusinessRolesEntity();
            businessRolesEntity.setRolesId(rolesEnum.getIndex());
            businessRolesEntity.setRolesName(rolesEnum.name());
            businessRolesEntity.setRolesDesc(rolesEnum.getValue());
            list.add(businessRolesEntity);
        }

        businessRolesMapper.batchInsert(list);
    }

    @Test
    public void selectRoles() {
        BusinessRolesEntity businessRolesEntity = new BusinessRolesEntity();
        businessRolesEntity.setRolesName(SystemRolesEnum.USER.name());
        businessRolesEntity = businessRolesMapper.selectByExample(businessRolesEntity);
        System.out.println(businessRolesEntity);
    }

}
