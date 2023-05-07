package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long>{
    
}
