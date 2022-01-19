package dev.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DepartmentDto {

    @NotBlank
    @Size(max = 50)
    private String nom;

    @NotBlank
    @Size(max = 3)
    private String code;

    @NotBlank
    @Size(max = 2)
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
