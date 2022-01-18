package dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cn_department")
public class Department extends BaseEntity {
    @Column(length = 50)
    private String name;


    private Integer departmentCode;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @OneToMany(mappedBy = "department")
    private List<City> cities;

    public Department() {
    }

    public Department(String name, Integer departmentCode, Region region, List<City> cities) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.region = region;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}