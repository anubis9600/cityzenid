package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto;

public class CommuneDTO {
    
    private Long id;
    private String designation;
    private String codeCommune;
    private VilleDTO villeDTO;
    // private List<Quartier> quartiers;

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

    public String getCodeCommune() {
        return this.codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public VilleDTO getVilleDTO() {
        return this.villeDTO;
    }

    public void setVilleDTO(VilleDTO villeDTO) {
        this.villeDTO = villeDTO;
    }

}
