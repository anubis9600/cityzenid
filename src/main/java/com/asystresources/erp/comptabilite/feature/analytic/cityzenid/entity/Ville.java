package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ville {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String codeVille;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @OneToMany(mappedBy = "ville")
    private List<Commune> communes;

    public Ville() {
    }

    public Ville(Long id, String designation, String codeVille, Province province, List<Commune> communes) {
        this.id = id;
        this.designation = designation;
        this.codeVille = codeVille;
        this.province = province;
        this.communes = communes;
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

    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Commune> getCommunes() {
        return this.communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", codeVille='" + getCodeVille() + "'" +
            ", province='" + getProvince() + "'" +
            ", communes='" + getCommunes() + "'" +
            "}";
    }

}
