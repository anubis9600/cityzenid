package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto;



public class VilleDTO {
    
    private Long id;
    private String designation;
    private String codeVille;
    private ProvinceDTO provinceDTO;

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

    public String getCodeVille() {
        return this.codeVille;
    }

    public void setCodeVille(String codeVille) {
        this.codeVille = codeVille;
    }

    public ProvinceDTO getProvinceDTO() {
        return this.provinceDTO;
    }

    public void setProvinceDTO(ProvinceDTO provinceDTO) {
        this.provinceDTO = provinceDTO;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeVille='" + getCodeVille() + "'" +
            ", provinceId='" + getProvinceDTO() + "'" +
            "}";
    }

}
