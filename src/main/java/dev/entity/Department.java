package dev.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "cn_department")
public class Department extends BaseEntity {

    @NotBlank
    @Column(length = 50)
    private String name;

    @NotBlank
    private String departmentCode;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @OneToMany(mappedBy = "department")
    private List<City> cities;

    public Department() {
    }

    public Department(String name, String departmentCode, Region region) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
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