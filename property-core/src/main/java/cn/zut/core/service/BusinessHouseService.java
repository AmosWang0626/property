package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.dao.entity.BusinessHouseRentEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessHouseService {

    /**
     * 添加房屋
     *
     * @param businessHouseRentEntity 房屋实体
     * @return 添加状态
     */
    GenericResponse addHouse(BusinessHouseRentEntity businessHouseRentEntity);

    /**
     * 根据房屋编号,获取房屋
     *
     * @param id 房屋编号
     * @return 单个房屋
     */
    GenericResponse<BusinessHouseRentEntity> getById(Integer id);

    /**
     * 获取所有房屋
     *
     * @return 房屋List
     */
    GenericResponse<List<BusinessHouseRentEntity>> houseRentList();

    /**
     * 根据id删除房屋
     *
     * @param id 房屋编号
     * @return 删除状态
     */
    GenericResponse deleteById(Integer id);

    /**
     * 更新房屋信息
     *
     * @param businessHouseRentEntity businessHouseRentEntity
     * @return GenericResponse
     */
    GenericResponse modifyHouse(BusinessHouseRentEntity businessHouseRentEntity);
}
