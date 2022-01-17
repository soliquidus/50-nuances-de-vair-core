package dev.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "city", indexes = {
        @Index(name = "id_department_cty", columnList = "id_department_cty")
})
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "zip_code", nullable = false)
    private Integer zipCode;

    @Column(name = "longitude", precision = 15, scale = 5)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 15, scale = 5)
    private BigDecimal latitude;

    @Column(name = "id_department_cty", nullable = false)
    private Long idDepartmentCty;

    public Long getIdDepartmentCty() {
        return idDepartmentCty;
    }

    public void setIdDepartmentCty(Long idDepartmentCty) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}