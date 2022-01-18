package dev.entity;

import dev.enums.QualityAir;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Air Pollution API concept
 *
 * @ Besides basic Air Quality Index, the API returns data about polluting gases,
 * such as Carbon monoxide (CO), Nitrogen monoxide (NO), Nitrogen dioxide (NO2),
 * Ozone (O3), Sulphur dioxide (SO2), Ammonia (NH3), and particulates (PM2.5 and PM10).
 */
@Entity
@Table(name = "cn_pollution")
public class Pollution extends BaseEntity {
    /**
     * Сoncentration of CO (Carbon monoxide), μg/m3
     */
    @Column(name = "co")
    private Long carbon;
    /**
     * Сoncentration of NO (Nitrogen monoxide), μg/m3
     */
    @Column(name = "no")
    private Long nitroMonoxide;
    /**
     * Сoncentration of NO2 (Nitrogen dioxide), μg/m3
     */
    @Column(name = "no2")
    private Long nitroDioxide;
    /**
     * Сoncentration of O3 (Ozone), μg/m3
     */
    @Column(name = "o3")
    private Long ozone;
    /**
     * Сoncentration of SO2 (Sulphur dioxide), μg/m3
     */
    @Column(name = "so2")
    private Long sulphur;
    /**
     * Сoncentration of PM2.5 (Fine particles matter)
     */
    @Column(name = "pm2_5")
    private Long fineParticles;
    /**
     * Сoncentration of PM10 (Coarse particulate matter)
     */
    @Column(name = "pm10")
    private Long coarseParticles;
    /**
     * Сoncentration of NH3 (Ammonia), μg/m3
     */
    @Column(name = "nh3")
    private Long ammonia;
    /**
     * Air Quality Index
     */
    @Enumerated
    @Column(name = "air_level")
    private QualityAir airQuality;

    /**
     * Datetoday
     */
    private LocalDateTime date;


    /**
     * CONSTRUTOR
     */
    public Pollution() {
    }

    public Pollution(Long carbon, Long nitroMonoxide, Long nitroDioxide, Long ozone, Long sulphur, Long fineParticles, Long coarseParticles, Long ammonia, QualityAir airQuality, LocalDateTime date) {
        this.carbon = carbon;
        this.nitroMonoxide = nitroMonoxide;
        this.nitroDioxide = nitroDioxide;
        this.ozone = ozone;
        this.sulphur = sulphur;
        this.fineParticles = fineParticles;
        this.coarseParticles = coarseParticles;
        this.ammonia = ammonia;
        this.airQuality = airQuality;
        this.date = date;
    }

    public Long getCarbon() {
        return carbon;
    }

    public void setCarbon(Long carbon) {
        this.carbon = carbon;
    }

    public Long getNitroMonoxide() {
        return nitroMonoxide;
    }

    public void setNitroMonoxide(Long nitroMonoxide) {
        this.nitroMonoxide = nitroMonoxide;
    }

    public Long getNitroDioxide() {
        return nitroDioxide;
    }

    public void setNitroDioxide(Long nitroDioxide) {
        this.nitroDioxide = nitroDioxide;
    }

    public Long getOzone() {
        return ozone;
    }

    public void setOzone(Long ozone) {
        this.ozone = ozone;
    }

    public Long getSulphur() {
        return sulphur;
    }

    public void setSulphur(Long sulphur) {
        this.sulphur = sulphur;
    }

    public Long getFineParticles() {
        return fineParticles;
    }

    public void setFineParticles(Long fineParticles) {
        this.fineParticles = fineParticles;
    }

    public Long getCoarseParticles() {
        return coarseParticles;
    }

    public void setCoarseParticles(Long coarseParticles) {
        this.coarseParticles = coarseParticles;
    }

    public Long getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(Long ammonia) {
        this.ammonia = ammonia;
    }

    public QualityAir getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(QualityAir airQuality) {
        this.airQuality = airQuality;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

