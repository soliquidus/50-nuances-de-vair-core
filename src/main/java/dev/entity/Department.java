package dev.entity;

import javax.persistence.*;

@Table(name = "department", indexes = {
        @Index(name = "id_region_dep", columnList = "id_region_dep")
})
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "department_code")
    private Integer departmentCode;

    @Column(name = "id_region_dep", nullable = false)
    private Long idRegionDep;

    public Long getIdRegionDep() {
        return idRegionDep;
    }

    public void setIdRegionDep(Long idRegionDep) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}