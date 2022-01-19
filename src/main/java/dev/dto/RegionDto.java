package dev.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegionDto {

    @NotBlank
    @Size(max = 100)
    private String nom;

    @NotBlank
    @Size(max = 2)
    private String code;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
