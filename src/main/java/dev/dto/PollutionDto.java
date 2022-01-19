package dev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.entity.Pollution;
import dev.enums.QualityAir;
import dev.json.PollutionJson;

import javax.persistence.Enumerated;
import java.time.LocalDateTime;

public class PollutionDto {
    /**
     * Сoncentration of CO (Carbon monoxide), μg/m3
     */
    @JsonProperty(value = "co")
    private Long carbon;
    /**
     * Сoncentration of NO (Nitrogen monoxide), μg/m3
     */
    @JsonProperty(value = "no")
    private Long nitroMonoxide;
    /**
     * Сoncentration of NO2 (Nitrogen dioxide), μg/m3
     */
    @JsonProperty(value = "no2")
    private Long nitroDioxide;
    /**
     * Сoncentration of O3 (Ozone), μg/m3
     */
    @JsonProperty(value = "o3")
    private Long ozone;
    /**
     * Сoncentration of SO2 (Sulphur dioxide), μg/m3
     */
    @JsonProperty(value = "so2")
    private Long sulphur;
    /**
     * Сoncentration of PM2.5 (Fine particles matter)
     */
    @JsonProperty(value = "pm2_5")
    private Long fineParticles;
    /**
     * Сoncentration of PM10 (Coarse particulate matter)
     */
    @JsonProperty(value = "pm10")
    private Long coarseParticles;
    /**
     * Сoncentration of NH3 (Ammonia), μg/m3
     */
    @JsonProperty(value = "nh3")
    private Long ammonia;
    /**
     * Air Quality Index
     */
    @Enumerated
    @JsonProperty(value = "air_level")
    private QualityAir airQuality;

    public PollutionDto() {
    }

    public PollutionDto(PollutionJson json){
        PollutionJson.Compos compo = json.getCompo();
        setCarbon(compo.getCarbon())
                .setNitroMonoxide(compo.getNitroMonoxide())
                .setNitroDioxide(compo.getNitroDioxide())
                .setOzone(compo.getOzone())
                .setSulphur(compo.getSulphur())
                .setFineParticles(compo.getFineParticles())
                .setCoarseParticles(compo.getCoarseParticles())
                .setAmmonia(compo.getAmmonia())
                .setAirQuality(compo.getAirQuality())
                .setDate(compo.getDate());
    }
    /**
     * Datetoday
     */
    private LocalDateTime date;

    public Long getCarbon() {
        return carbon;
    }

    public Long getNitroMonoxide() {
        return nitroMonoxide;
    }

    public Long getNitroDioxide() {
        return nitroDioxide;
    }

    public Long getOzone() {
        return ozone;
    }

    public Long getSulphur() {
        return sulphur;
    }

    public Long getFineParticles() {
        return fineParticles;
    }

    public Long getCoarseParticles() {
        return coarseParticles;
    }

    public Long getAmmonia() {
        return ammonia;
    }

    public QualityAir getAirQuality() {
        return airQuality;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public PollutionDto setCarbon(Long carbon) {
        this.carbon = carbon;
        return this;
    }

    public PollutionDto setNitroMonoxide(Long nitroMonoxide) {
        this.nitroMonoxide = nitroMonoxide;
        return this;
    }

    public PollutionDto setNitroDioxide(Long nitroDioxide) {
        this.nitroDioxide = nitroDioxide;
        return this;
    }

    public PollutionDto setOzone(Long ozone) {
        this.ozone = ozone;
        return this;
    }

    public PollutionDto setSulphur(Long sulphur) {
        this.sulphur = sulphur;
        return this;
    }

    public PollutionDto setFineParticles(Long fineParticles) {
        this.fineParticles = fineParticles;
        return this;
    }

    public PollutionDto setCoarseParticles(Long coarseParticles) {
        this.coarseParticles = coarseParticles;
        return this;
    }

    public PollutionDto setAmmonia(Long ammonia) {
        this.ammonia = ammonia;
        return this;
    }

    public PollutionDto setAirQuality(QualityAir airQuality) {
        this.airQuality = airQuality;
        return this;
    }

    public PollutionDto setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Pollution convert(){
        return new Pollution(getCarbon(),getNitroMonoxide(),getNitroDioxide(),
                getOzone(),getSulphur(),getFineParticles(),
                getCoarseParticles(),getAmmonia(),getAirQuality(),getDate());
    }
}
