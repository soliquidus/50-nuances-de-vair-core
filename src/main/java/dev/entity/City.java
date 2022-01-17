package dev.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "city")
public class City extends BaseEntity {
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "zip_code", nullable = false)
    private Integer zipCode;

    @Column(name = "longitude", precision = 15, scale = 5)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 15, scale = 5)
    private BigDecimal latitude;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_department_cty", nullable = false)
    private Department idDepartmentCty;

    public Department getIdDepartmentCty() {
        return idDepartmentCty;
    }

    public void setIdDepartmentCty(Department idDepartmentCty) {
        this.idDepartmentCty = idDepartmentCty;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}