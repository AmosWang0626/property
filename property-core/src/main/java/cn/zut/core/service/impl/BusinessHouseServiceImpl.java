package cn.zut.core.service.impl;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessHouseService;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import cn.zut.dao.persistence.BusinessHouseRentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessHouseService")
public class BusinessHouseServiceImpl implements BusinessHouseService {

    @Resource
    private BusinessHouseRentMapper businessHouseRentMapper;

    /**
     * 添加房源信息
     */
    @Override
    public GenericResponse addHouse(BusinessHouseRentEntity businessHouseRentEntity) {
        /*
         * 下边就要做一些校验了
         */
        String houseNo = businessHouseRentEntity.getHouseNo();
        businessHouseRentEntity.setCreateTime(new Date());

        BusinessHouseRentEntity search = new BusinessHouseRentEntity();
        search.setHouseNo(houseNo);
        search = businessHouseRentMapper.selectByExample(search);
        if (search != null) {
            switch (search.getRentStatus()) {
                // 已租出,不允许添加
                case RENT_ED:
                    return new GenericResponse<>(new ExceptionMessage(ExceptionCode.BUSINESS_ADD_HOUSE_RENT_FAIL, "房屋已存在,并已租出"));

                // 租售ing,不允许添加
                case RENT_ING:
                    return new GenericResponse(new ExceptionMessage(ExceptionCode.BUSINESS_ADD_HOUSE_RENT_FAIL, "房屋已存在,并租售中"));

                // 租售ing,不允许添加
                case UN_RENT:
                    return new GenericResponse(new ExceptionMessage(ExceptionCode.BUSINESS_ADD_HOUSE_RENT_FAIL, "房屋已存在,且未租出"));
                default:
                    break;
            }
        }

        int insert = businessHouseRentMapper.insert(businessHouseRentEntity);
        if (insert > 0) {
            return GenericResponse.SUCCESS;
        } else {
            return GenericResponse.FAIL;
        }
    }

    /**
     * 根据id获取信息
     */
    @Override
    public GenericResponse<BusinessHouseRentEntity> getById(Integer id) {
        return new GenericResponse<>(businessHouseRentMapper.selectById(id));
    }

    /**
     * @return 所有房子信息列表
     */
    @Override
    public GenericResponse<List<BusinessHouseRentEntity>> houseRentList() {
        return new GenericResponse<>(businessHouseRentMapper.selectListByExample(null));
    }

    @Override
    public GenericResponse modifyHouse(BusinessHouseRentEntity businessHouseRentEntity) {
        int i = businessHouseRentMapper.update(businessHouseRentEntity);
        if (i > 0) {
            return GenericResponse.SUCCESS;
        } else {
            return GenericResponse.FAIL;
        }
    }

    /**
     * 根据id删除信息
     */
    @Override
    public GenericResponse deleteById(Integer id) {
        int i = businessHouseRentMapper.deleteById(id);
        if (i > 0) {
            return GenericResponse.SUCCESS;
        } else {
            return GenericResponse.FAIL;
        }
    }
}
