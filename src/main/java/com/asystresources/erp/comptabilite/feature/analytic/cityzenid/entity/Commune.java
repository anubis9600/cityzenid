package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commune {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String codeVille;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "commune")
    private List<Quartier> quartiers;

    public Commune() {
    }

    public Commune(Long id, String designation, String codeVille, Ville ville, List<Quartier> quartiers) {
        this.id = id;
        this.designation = designation;
        this.codeVille = codeVille;
        this.ville = ville;
        this.quartiers = quartiers;
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

    public String getCodeVille() {
        return this.codeVille;
    }

    public void setCodeVille(String codeVille) {
        this.codeVille = codeVille;
    }

    public Ville getVille() {
        return this.ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Quartier> getQuartiers() {
        return this.quartiers;
    }

    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeVille='" + getCodeVille() + "'" +
            ", ville='" + getVille() + "'" +
            ", quartiers='" + getQuartiers() + "'" +
            "}";
    }


}
