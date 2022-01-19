package dev.dto;

public class CityGeocode {

    private String zip;
    private String name;
    private Double lat;
    private Double lon;
    private String country;

    public String getZip() {
        return zip;
    }

    public CityGeocode setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getName() {
        return name;
    }

    public CityGeocode setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public CityGeocode setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public CityGeocode setLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CityGeocode setCountry(String country) {
        this.country = country;
        return this;
    }
}
