package cn.zut.dao.entity;

public class HouseRentEntity {
    private Integer id;

    private String type;

    private Double area;

    private String address;

    private Double rent;

    private String details;

    private String img;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HouseRentEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", rent=" + rent +
                ", details='" + details + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}