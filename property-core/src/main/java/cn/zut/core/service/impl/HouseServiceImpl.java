package cn.zut.core.service.impl;

import cn.zut.core.service.HouseService;
import cn.zut.dao.entity.HouseRentEntity;
import cn.zut.dao.persistence.HouseRentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("houseService")
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseRentMapper houseRentMapper;

    /**
     * @return 所有房子信息列表
     */
    @Override
    public List<HouseRentEntity> houseRentList() {
        return houseRentMapper.selectListByExample(null);
    }

    /**
     * 根据id删除信息
     */
    @Override
    public boolean deleteById(int id) {
        int x = houseRentMapper.deleteById(id);
        return x > 0;
    }

    /**
     * 根据id获取信息
     */
    @Override
    public HouseRentEntity getById(int id) {
        return houseRentMapper.selectById(id);
    }

    /**
     * 添加房源信息
     */
    @Override
    public boolean addHouse(HouseRentEntity houseRentEntity) {
        Integer houseId = houseRentEntity.getId();
        int x;
        if (houseId != null) {
            HouseRentEntity houseEntityTemp = houseRentMapper.selectById(houseId);
            x = houseRentMapper.update(houseEntityTemp);
        } else {
            x = houseRentMapper.insert(houseRentEntity);
        }
        return x > 0;
    }
}
