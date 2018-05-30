package cn.zut.dao.entity;



import lombok.Data;

import java.util.Date;

@Data
public class ManageEnterpriseEntity {
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
     * 创建时间
     */
    private Date settledTime;

    public String getEnterpriseName(){ return enterpriseName;}

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Date getSettledTime() {
        return settledTime;
    }

    public void setSettledTime(Date settledTime) {
        this.settledTime = settledTime;
    }
}
