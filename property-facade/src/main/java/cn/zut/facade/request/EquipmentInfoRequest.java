package cn.zut.facade.request;

import lombok.Data;

/**
 * @author DaoyuanWang
 */
@Data
public class EquipmentInfoRequest {
    /**
     * 设备ID
     */
    private Long id;
    /**
     * 设备类型
     */
    private String types;
    /**
     * 设备数量
     */
    private String amount;
}
