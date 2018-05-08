package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessCarSetService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.persistence.BusinessCarSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessCarSetService")
public class BusinessCarSetServiceImpl implements BusinessCarSetService {

    @Resource
    private BusinessCarSetMapper businessCarSetMapper;

    /**
     * 添加车辆进入信息
     */
    @Override
    public boolean addCarSet(BusinessCarSetEntity businessCarSetEntity) {
        int x = businessCarSetMapper.insert(businessCarSetEntity);
        return x > 0;
    }

    /**
     * 查看所有的车辆信息
     */
    @Override
    public List<BusinessCarSetEntity> carList() {
        return businessCarSetMapper.selectListByExample(null);
    }

    /**
     * 获取车辆信息
     */
    @Override
    public BusinessCarSetEntity searchCarSet(int id) {
        return businessCarSetMapper.selectById(id);
    }

    @Override
    public boolean rentCar(BusinessCarSetEntity businessCarSetEntity) {
        int x = businessCarSetMapper.update(businessCarSetEntity);
        return x > 0;
    }
}
