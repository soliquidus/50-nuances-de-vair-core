package dev.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "pollution")
public class Pollution extends BaseEntity {
    @Column(name = "nitrogen_dioxide")
    private Integer nitrogenDioxide;

    @Column(name = "particulates")
    private Integer particulates;

    @Column(name = "ozones")
    private Integer ozones;

    @Column(name = "date_time")
    private Instant dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_city_ptn", nullable = false)
    private City idCityPtn;

    public City getIdCityPtn() {
        return idCityPtn;
    }

    public void setIdCityPtn(City idCityPtn) {
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
}