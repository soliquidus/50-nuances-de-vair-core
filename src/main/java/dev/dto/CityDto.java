package dev.dto;

import javax.validation.constraints.NotBlank;

public class CityDto {

    @NotBlank
    private String nom;

    @NotBlank
    private String codeDepartement;

    @NotBlank
    private String[] codesPostaux;

    Long census;

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

    public Long getCensus() {
        return census;
    }

    public CityDto setCensus(Long census) {
        this.census = census;
        return this;
    }
}
