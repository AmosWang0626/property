package cn.zut.core.service.impl;

import cn.zut.core.service.CarSetService;
import cn.zut.dao.entity.CarSetEntity;
import cn.zut.dao.persistence.CarSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("carSetService")
public class CarSetServiceImpl implements CarSetService {

    @Resource
    private CarSetMapper carSetMapper;

    /**
     * 添加车辆进入信息
     */
    @Override
    public boolean addCarSet(CarSetEntity carSetEntity) {
        int x = carSetMapper.insert(carSetEntity);
        return x > 0;
    }

    /**
     * 查看所有的车辆信息
     */
    @Override
    public List<CarSetEntity> carList() {
        return carSetMapper.selectListByExample(null);
    }

    /**
     * 获取车辆信息
     */
    @Override
    public CarSetEntity searchCarSet(int id) {
        return carSetMapper.selectById(id);
    }

    @Override
    public boolean rentCar(CarSetEntity carSetEntity) {
        int x = carSetMapper.update(carSetEntity);
        return x > 0;
    }
}
