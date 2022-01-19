package dev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonNode;
import dev.entity.Pollution;
import dev.enums.QualityAir;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties({"coord"})
public class PollutionDto {

    private Coord coord;
    @JsonProperty(value = "list")
    private List<Compos> compo;

    public Compos getCompo() {
        return compo.get(0);
    }

    public class Coord{
        private Long lon;
        private Long lat;
        public Long getLon() {
            return lon;
        }
        public Long getLat() {
            return lat;
        }
    }
    @JsonRootName(value = "components")
    public static class Compos{
        @JsonProperty(value = "main")
        private JsonNode airQuality;
        @JsonProperty(value = "components")
        private Pollution pollution;
        @JsonProperty(value = "dt")
        private String date;

        public QualityAir getAirQuality() {
            return  QualityAir.byIndex(airQuality.path("aqi").asInt());
        }
        public LocalDateTime getDate(){
            return LocalDateTime.now();
        }
        public Long getCarbon() {
            return pollution.getCarbon();
        }

        public Long getNitroMonoxide() {
            return pollution.getNitroMonoxide();
        }

        public Long getNitroDioxide() {
            return pollution.getNitroDioxide();
        }

        public Long getOzone() {
            return pollution.getOzone();
        }

        public Long getSulphur() {
            return pollution.getSulphur();
        }

        public Long getFineParticles() {
            return pollution.getFineParticles();
        }

        public Long getCoarseParticles() {
            return pollution.getCoarseParticles();
        }

        public Long getAmmonia() {
            return pollution.getAmmonia();
        }

    }
}

