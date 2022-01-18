package dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cn_region")
public class Region extends BaseEntity {
    @Column(length = 25)
    private String name;

    @Column(length = 2)
    private String regionCode;

    @OneToMany(mappedBy = "cities")
    private List<Department> department;

    public Region() {
    }

    public Region(String name, String regionCode, List<Department> department) {
        this.name = name;
        this.regionCode = regionCode;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
}