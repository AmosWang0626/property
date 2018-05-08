package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import cn.zut.dao.persistence.BusinessHouseRentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessHouseService")
public class BusinessHouseServiceImpl implements BusinessHouseService {

    @Resource
    private BusinessHouseRentMapper businessHouseRentMapper;

    /**
     * @return 所有房子信息列表
     */
    @Override
    public List<BusinessHouseRentEntity> houseRentList() {
        return businessHouseRentMapper.selectListByExample(null);
    }

    /**
     * 根据id删除信息
     */
    @Override
    public boolean deleteById(int id) {
        int x = businessHouseRentMapper.deleteById(id);
        return x > 0;
    }

    /**
     * 根据id获取信息
     */
    @Override
    public BusinessHouseRentEntity getById(int id) {
        return businessHouseRentMapper.selectById(id);
    }

    /**
     * 添加房源信息
     */
    @Override
    public boolean addHouse(BusinessHouseRentEntity businessHouseRentEntity) {
        Integer houseId = businessHouseRentEntity.getId();
        int x;
        if (houseId != null) {
            BusinessHouseRentEntity houseEntityTemp = businessHouseRentMapper.selectById(houseId);
            x = businessHouseRentMapper.update(houseEntityTemp);
        } else {
            x = businessHouseRentMapper.insert(businessHouseRentEntity);
        }
        return x > 0;
    }
}
