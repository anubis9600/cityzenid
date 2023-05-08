package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
    
}
