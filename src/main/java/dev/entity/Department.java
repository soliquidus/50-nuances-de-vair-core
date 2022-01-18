package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department extends BaseEntity {
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "department_code")
    private Integer departmentCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_region_dep", nullable = false)
    private Region idRegionDep;

    public Region getIdRegionDep() {
        return idRegionDep;
    }

    public void setIdRegionDep(Region idRegionDep) {
        this.idRegionDep = idRegionDep;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}