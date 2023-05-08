package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto;

import java.util.List;

public class ProvinceDTO {
    
    private Long id;
    private String designation;
    private String codeProvince;
    private List<VilleDTO> villes;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCodeProvince() {
        return this.codeProvince;
    }

    public void setCodeProvince(String codeProvince) {
        this.codeProvince = codeProvince;
    }

    public List<VilleDTO> getVilles() {
        return this.villes;
    }

    public void setVilles(List<VilleDTO> villes) {
        this.villes = villes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeProvince='" + getCodeProvince() + "'" +
            ", villes='" + getVilles() + "'" +
            "}";
    }



}
