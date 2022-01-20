package dev.dto.api;

public class CityJson {

    String type;
    String version;
    FeaturesJson[] features;
    String attribution;
    String licence;
    String query;
    FiltersJson filtersJson;
    String limit;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public FeaturesJson[] getFeatures() {
        return features;
    }

    public void setFeatures(FeaturesJson[] features) {
        this.features = features;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public FiltersJson getFilters() {
        return filtersJson;
    }

    public void setFilters(FiltersJson filtersJson) {
        this.filtersJson = filtersJson;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
