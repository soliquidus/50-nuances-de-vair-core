package dev.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.enums.QualityAir;
import dev.dto.PollutionDto;

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
    @JsonProperty(value = "co")
    private Long carbon;
    /**
     * Сoncentration of NO (Nitrogen monoxide), μg/m3
     */
    @Column(name = "no")
    @JsonProperty(value = "no")
    private Long nitroMonoxide;
    /**
     * Сoncentration of NO2 (Nitrogen dioxide), μg/m3
     */
    @Column(name = "no2")
    @JsonProperty(value = "no2")
    private Long nitroDioxide;
    /**
     * Сoncentration of O3 (Ozone), μg/m3
     */
    @Column(name = "o3")
    @JsonProperty(value = "o3")
    private Long ozone;
    /**
     * Сoncentration of SO2 (Sulphur dioxide), μg/m3
     */
    @Column(name = "so2")
    @JsonProperty(value = "so2")
    private Long sulphur;
    /**
     * Сoncentration of PM2.5 (Fine particles matter)
     */
    @Column(name = "pm2_5")
    @JsonProperty(value = "pm2_5")
    private Long fineParticles;
    /**
     * Сoncentration of PM10 (Coarse particulate matter)
     */
    @Column(name = "pm10")
    @JsonProperty(value = "pm10")
    private Long coarseParticles;
    /**
     * Сoncentration of NH3 (Ammonia), μg/m3
     */
    @Column(name = "nh3")
    @JsonProperty(value = "nh3")
    private Long ammonia;
    /**
     * Air Quality Index
     */
    @Enumerated
    @Column(name = "air_level")
    @JsonProperty(value = "air_level")
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

    public Pollution(Long carbon, Long nitroMonoxide, Long nitroDioxide, Long ozone,
                     Long sulphur, Long fineParticles, Long coarseParticles, Long ammonia,
                     QualityAir airQuality, LocalDateTime date) {
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

    public Pollution(PollutionDto pollutionDto){
        this
                .setCarbon(pollutionDto.getCarbon())
                .setNitroMonoxide(pollutionDto.getNitroMonoxide())
                .setNitroDioxide(pollutionDto.getNitroDioxide())
                .setOzone(pollutionDto.getOzone())
                .setSulphur(pollutionDto.getSulphur())
                .setFineParticles(pollutionDto.getFineParticles())
                .setCoarseParticles(pollutionDto.getCoarseParticles())
                .setAmmonia(pollutionDto.getAmmonia())
                .setAirQuality(pollutionDto.getAirQuality())
                .setDate(pollutionDto.getDate());
    }

    public Long getCarbon() {
        return carbon;
    }

    public Pollution setCarbon(Long carbon) {
        this.carbon = carbon;
        return this;
    }

    public Long getNitroMonoxide() {
        return nitroMonoxide;
    }

    public Pollution setNitroMonoxide(Long nitroMonoxide) {
        this.nitroMonoxide = nitroMonoxide;
        return this;
    }

    public Long getNitroDioxide() {
        return nitroDioxide;
    }

    public Pollution setNitroDioxide(Long nitroDioxide) {
        this.nitroDioxide = nitroDioxide;
        return this;
    }

    public Long getOzone() {
        return ozone;
    }

    public Pollution setOzone(Long ozone) {
        this.ozone = ozone;
        return this;
    }

    public Long getSulphur() {
        return sulphur;
    }

    public Pollution setSulphur(Long sulphur) {
        this.sulphur = sulphur;
        return this;
    }

    public Long getFineParticles() {
        return fineParticles;
    }

    public Pollution setFineParticles(Long fineParticles) {
        this.fineParticles = fineParticles;
        return this;
    }

    public Long getCoarseParticles() {
        return coarseParticles;
    }

    public Pollution setCoarseParticles(Long coarseParticles) {
        this.coarseParticles = coarseParticles;
        return this;
    }

    public Long getAmmonia() {
        return ammonia;
    }

    public Pollution setAmmonia(Long ammonia) {
        this.ammonia = ammonia;
        return this;
    }

    public QualityAir getAirQuality() {
        return airQuality;
    }

    public Pollution setAirQuality(QualityAir airQuality) {
        this.airQuality = airQuality;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Pollution setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}

