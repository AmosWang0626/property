package cn.zut.facade.request;

import cn.zut.facade.enums.BusinessTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: TariffCompanyRequest
 *
 * @author DaoyuanWang
 * @date 2018/3/24
 */
@Data
public class TariffCompanyRequest {
    /**
     * 公司编号
     */
    private Long companyId;
    /**
     * 业务类型
     */
    private BusinessTypeEnum business;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 省市地址
     */
    private List<String> city;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司联系方式
     */
    private String telephone;
    /**
     * 组织机构代码
     */
    private String organizationCode;
    /**
     * 企业法人名字
     */
    private String legalName;
    /**
     * 成立时间
     */
    private String establish;
    /**
     * 注册资金
     */
    private String registerCapital;
}
