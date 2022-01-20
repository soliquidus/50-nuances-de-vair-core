package dev.dto.api;

public class FeaturesJson {

    String type;
    GeometryJson geometry;
    PropertiesJson properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeometryJson getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryJson geometry) {
        this.geometry = geometry;
    }

    public PropertiesJson getProperties() {
        return properties;
    }

    public void setProperties(PropertiesJson properties) {
        this.properties = properties;
    }
}
