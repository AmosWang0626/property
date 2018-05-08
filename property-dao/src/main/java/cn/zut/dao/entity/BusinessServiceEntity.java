package cn.zut.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author LiuBowen
 */
@Data
public class BusinessServiceEntity {

    /**
     * 自增id
     */
    private Integer id;
    /**
     * 申请人用户编号
     */
    private Long memberId;
    /**
     * 服务类型
     */
    private String type;
    /**
     * 申请理由
     */
    private String details;
    /**
     * 申请状态
     */
    private String status;
    /**
     * 评估说明
     */
    private String evaluate;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 处理时间
     */
    private Date detailTime;
    /**
     * 完成时间
     */
    private Date endTime;

}