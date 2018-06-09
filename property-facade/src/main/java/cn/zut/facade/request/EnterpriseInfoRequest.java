package cn.zut.facade.request;


import lombok.Data;

import java.util.Date;

/**
 * @author YangShangYu
 */
@Data
public class EnterpriseInfoRequest {
    private Long id;
    /**
     * 公司名称
     */
    private String enterpriseName;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司联系方式
     */
    private String phone;
    /**
     * 企业法人名字
     */
    private String leaderName;
    /**
     * 成立时间
     */
    private Date settledTime;
}
