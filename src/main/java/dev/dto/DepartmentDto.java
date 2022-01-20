package dev.dto;

import javax.validation.constraints.NotBlank;

public class DepartmentDto {

    @NotBlank
    private String nom;

    @NotBlank
    private String code;

    @NotBlank
    private String codeRegion;

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

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }
}
