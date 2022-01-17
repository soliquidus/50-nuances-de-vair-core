package dev.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "pollution", indexes = {
        @Index(name = "id_city_ptn", columnList = "id_city_ptn", unique = true)
})
@Entity
public class Pollution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nitrogen_dioxide")
    private Integer nitrogenDioxide;

    @Column(name = "particulates")
    private Integer particulates;

    @Column(name = "ozones")
    private Integer ozones;

    @Column(name = "date_time")
    private Instant dateTime;

    @Column(name = "id_city_ptn", nullable = false)
    private Long idCityPtn;

    public Long getIdCityPtn() {
        return idCityPtn;
    }

    public void setIdCityPtn(Long idCityPtn) {
        this.idCityPtn = idCityPtn;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getOzones() {
        return ozones;
    }

    public void setOzones(Integer ozones) {
        this.ozones = ozones;
    }

    public Integer getParticulates() {
        return particulates;
    }

    public void setParticulates(Integer particulates) {
        this.particulates = particulates;
    }

    public Integer getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(Integer nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}