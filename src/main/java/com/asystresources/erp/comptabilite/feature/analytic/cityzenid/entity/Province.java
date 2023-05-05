package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Province {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String codeProvince;
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private List<Ville> villes;

    public Province(){
        
    }

    public Province(Long id, String designation, String codeProvince, List<Ville> villes) {
        this.id = id;
        this.designation = designation;
        this.codeProvince = codeProvince;
        this.villes = villes;
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

    public List<Ville> getVilles() {
        return this.villes;
    }

    public void setVilles(List<Ville> villes) {
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
