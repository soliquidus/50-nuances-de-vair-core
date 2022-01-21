package dev.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityJson {

    @JsonProperty("features")
    FeaturesJson[] featuresJsons;

    public FeaturesJson[] getFeaturesJsons() {
        return featuresJsons;
    }

    public CityJson setFeaturesJsons(FeaturesJson[] featuresJsons) {
        this.featuresJsons = featuresJsons;
        return this;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FeaturesJson {

        @JsonProperty("geometry")
        GeometryJson geometryJson;

        @JsonProperty("properties")
        PropertiesJson propertiesJson;

        public GeometryJson getGeometryJson() {
            return geometryJson;
        }

        public FeaturesJson setGeometryJson(GeometryJson geometryJson) {
            this.geometryJson = geometryJson;
            return this;
        }

        public PropertiesJson getPropertiesJson() {
            return propertiesJson;
        }

        public FeaturesJson setPropertiesJson(PropertiesJson propertiesJson) {
            this.propertiesJson = propertiesJson;
            return this;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeometryJson {

        @JsonProperty("coordinates")
        Double[] geoLocalisation;

        public Double[] getGeoLocalisation() {
            return geoLocalisation;
        }

        public GeometryJson setGeoLocalisation(Double[] geoLocalisation) {
            this.geoLocalisation = geoLocalisation;
            return this;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PropertiesJson {

        @JsonProperty("population")
        Long census;

        public Long getCensus() {
            return census;
        }

        public PropertiesJson setCensus(Long census) {
            this.census = census;
            return this;
        }
    }

}
