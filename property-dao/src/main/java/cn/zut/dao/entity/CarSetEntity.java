package cn.zut.dao.entity;

import java.util.Date;

public class CarSetEntity {
    private Integer id;

    private Date comedate;

    private Date leavedate;

    private String cartype;

    private String carnumber;

    private Double rent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getComedate() {
        return comedate;
    }

    public void setComedate(Date comedate) {
        this.comedate = comedate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "CarSetEntity{" +
                "id=" + id +
                ", comedate=" + comedate +
                ", leavedate=" + leavedate +
                ", cartype='" + cartype + '\'' +
                ", carnumber='" + carnumber + '\'' +
                ", rent=" + rent +
                '}';
    }
}