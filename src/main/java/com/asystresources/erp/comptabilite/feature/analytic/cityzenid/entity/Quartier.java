package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Quartier {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String codeQuartier;
    @ManyToOne
    private Commune commune;


    public Quartier() {
    }

    public Quartier(Long id, String designation, String codeQuartier, Commune commune) {
        this.id = id;
        this.designation = designation;
        this.codeQuartier = codeQuartier;
        this.commune = commune;
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

    public Commune getCommune() {
        return this.commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeQuartier='" + getCodeQuartier() + "'" +
            ", commune='" + getCommune() + "'" +
            "}";
    }


}
