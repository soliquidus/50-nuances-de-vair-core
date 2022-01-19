package dev.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CityDto {

    @NotBlank
    @Size(max = 50)
    private String nom;

    @NotBlank
    private String codeDepartement;

    @NotBlank
    private String[] codesPostaux;

    private double lon;

    private double lat;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String[] getCodesPostaux() {
        return codesPostaux;
    }

    public void setCodesPostaux(String[] codesPostaux) {
        this.codesPostaux = codesPostaux;
    }

    public double getLon() {
        return lon;
    }

    public CityDto setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public CityDto setLat(double lat) {
        this.lat = lat;
        return this;
    }
}
