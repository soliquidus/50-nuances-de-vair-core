package dev.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityJson {

    @JsonProperty("features")
    FeaturesJson[] featuresJsons;




    public Double getLongitude() {
        return featuresJsons[0].getGeometryJson().geoLocalisation[0];
    }

    public Double getLatitude() {
        return featuresJsons[0].getGeometryJson().geoLocalisation[1];
    }

    public Long getCensus() {
        return featuresJsons[0].getPropertiesJson().getCensus();
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


        public PropertiesJson getPropertiesJson() {
            return propertiesJson;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeometryJson {

        @JsonProperty("coordinates")
        Double[] geoLocalisation;

        public Double[] getGeoLocalisation() {
            return geoLocalisation;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PropertiesJson {

        @JsonProperty("population")
        Long census;

        public Long getCensus() {
            return census;
        }

    }

}
