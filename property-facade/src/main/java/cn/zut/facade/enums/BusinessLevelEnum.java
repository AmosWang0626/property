package cn.zut.facade.enums;

import cn.zut.common.api.ComboVO;
import cn.zut.common.api.Mapping;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/12/15
 *
 * @author DaoYuanWang
 */
public enum BusinessLevelEnum implements Mapping<String, String> {

    /**
     * 物业费标准
     */
    PROPERTY_ONE("物业费一级标准"),
    /*PROPERTY_TWO("物业费二级标准"),
    PROPERTY_THREE("物业费三级标准"),
    PROPERTY_FORE("物业费四级标准"),*/
    /**
     * 场地使用费标准
     */
    SITE_ONE("场地使用费一级标准"),
    SITE_TWO("场地使用费二级标准"),
    /*SITE_THREE("场地使用费三级标准"),
    SITE_FORE("场地使用费四级标准"),
    SITE_FIVE("场地使用费五级标准"),*/
    /**
     * 水费标准
     */
    /*WATER_LIVE("水费家庭用水标准"),*/
    WATER_COMPANY("水费企业用水标准"),
    /**
     * 电费标准
     */
    /*ELECTRICITY_LIVE("电费家庭用电标准"),*/
    ELECTRICITY_COMPANY("电费企业用电标准"),
    /**
     * 网费标准
     */
    /*NETWORK_LIVE("网费家庭标准"),*/
    NETWORK_COMPANY("网费企业标准"),
    /**
     * 停车费标准
     */
    PARKING_LIGHT_ONE_2_FOUR_HOUR("停车费-白天-地上3元"),
    PARKING_LIGHT_FOUR_2_TWELVE_HOUR("停车费-白天-地上6元"),
    PARKING_NIGHT_ONE_2_FOUR_HOUR("停车费-晚上-地上4元"),
    PARKING_NIGHT_FOUR_2_TWELVE_HOUR("停车费-晚上-地上8元"),;

    private final String value;

    BusinessLevelEnum(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return value;
    }

    /**
     * 传入字符串返回匹配枚举, 使用者要对null进行处理
     *
     * @param value 字符串key
     * @return this
     */
    public static BusinessLevelEnum values2(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (BusinessLevelEnum businessLevelEnum : BusinessLevelEnum.values()) {
            if (businessLevelEnum.getKey().equals(value)) {
                return businessLevelEnum;
            }
        }
        return null;
    }

    /**
     * 物业费
     */
    public static List<ComboVO> getPropertyList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(PROPERTY_ONE));
        return comboVOList;
    }

    /**
     * 场地使用费
     */
    public static List<ComboVO> getSiteList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(SITE_ONE));
        comboVOList.add(new ComboVO<>(SITE_TWO));
        /*comboVOList.add(new ComboVO<>(SITE_THREE));
        comboVOList.add(new ComboVO<>(SITE_FORE));
        comboVOList.add(new ComboVO<>(SITE_FIVE));*/
        return comboVOList;
    }

    /**
     * 水费
     */
    public static List<ComboVO> getWaterList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        /*comboVOList.add(new ComboVO<>(WATER_LIVE));*/
        comboVOList.add(new ComboVO<>(WATER_COMPANY));
        return comboVOList;
    }

    /**
     * 网费
     */
    public static List<ComboVO> getNetworkList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        /*comboVOList.add(new ComboVO<>(NETWORK_LIVE));*/
        comboVOList.add(new ComboVO<>(NETWORK_COMPANY));
        return comboVOList;
    }

    /**
     * 电费
     */
    public static List<ComboVO> getElectricityList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        /*comboVOList.add(new ComboVO<>(ELECTRICITY_LIVE));*/
        comboVOList.add(new ComboVO<>(ELECTRICITY_COMPANY));
        return comboVOList;
    }

    /**
     * 停车费
     */
    public static List<ComboVO> getParkingList() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(PARKING_LIGHT_ONE_2_FOUR_HOUR));
        comboVOList.add(new ComboVO<>(PARKING_LIGHT_FOUR_2_TWELVE_HOUR));
        comboVOList.add(new ComboVO<>(PARKING_NIGHT_ONE_2_FOUR_HOUR));
        comboVOList.add(new ComboVO<>(PARKING_NIGHT_FOUR_2_TWELVE_HOUR));
        return comboVOList;
    }
}
