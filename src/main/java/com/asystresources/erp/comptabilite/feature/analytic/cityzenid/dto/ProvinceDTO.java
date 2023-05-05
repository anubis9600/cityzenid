package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto;

public class ProvinceDTO {
    
    private Long id;
    private String designation;
    private String codeProvince;

    public ProvinceDTO(){
        
    }

    public ProvinceDTO(Long id, String designation, String codeProvince) {
        this.id = id;
        this.designation = designation;
        this.codeProvince = codeProvince;
    }

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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeProvince='" + getCodeProvince() + "'" +
            "}";
    }


}
