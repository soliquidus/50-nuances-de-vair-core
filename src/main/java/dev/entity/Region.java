package dev.entity;

import dev.dto.RegionDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "cn_region")
public class Region extends BaseEntity {

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column(length = 2)
    private String regionCode;

    @OneToMany(mappedBy = "cities")
    private List<Department> department;// the set is preferred

    public Region() {
    }

    public Region(String name, String regionCode) {
        this.name = name;
        this.regionCode = regionCode;
    }
    public Region(RegionDto regionDto){
        this.name = regionDto.getNom();
        this.regionCode = regionDto.getCode();
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