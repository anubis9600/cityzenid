package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto;

public class QuartierDTO {
    
    private Long id;
    private String designation;
    private String codeQuartier;
    private CommuneDTO communeDTO;


    public QuartierDTO() {
    }

    public QuartierDTO(Long id, String designation, String codeQuartier, CommuneDTO communeDTO) {
        this.id = id;
        this.designation = designation;
        this.codeQuartier = codeQuartier;
        this.communeDTO = communeDTO;
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

    public String getCodeQuartier() {
        return this.codeQuartier;
    }

    public void setCodeQuartier(String codeQuartier) {
        this.codeQuartier = codeQuartier;
    }

    public CommuneDTO getCommuneDTO() {
        return this.communeDTO;
    }

    public void setCommuneDTO(CommuneDTO communeDTO) {
        this.communeDTO = communeDTO;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeQuartier='" + getCodeQuartier() + "'" +
            ", commune='" + getCommuneDTO() + "'" +
            "}";
    }


}
