package cn.zut.facade.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/6/7
 */
@Data
public class BusinessSeriesDataVO implements Serializable {

    private static final long serialVersionUID = 4842786489519450445L;

    private List<String> month;
    private List<BigDecimal> water;
    private List<BigDecimal> electricity;
    private List<BigDecimal> network;
    private List<BigDecimal> site;
    private List<BigDecimal> property;
    private List<BigDecimal> parking;

    public void init() {
        month = new ArrayList<>();
        water = new ArrayList<>();
        electricity = new ArrayList<>();
        network = new ArrayList<>();
        site = new ArrayList<>();
        property = new ArrayList<>();
        parking = new ArrayList<>();
    }
}
