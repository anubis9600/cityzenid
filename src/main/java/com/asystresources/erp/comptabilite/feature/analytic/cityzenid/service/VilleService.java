package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;

public interface VilleService {
    
    VilleDTO saveVille(VilleDTO villeDTO, Long provinceId) throws ProvinceNotFoundException;

    Ville getVilleById(Long idVille);

    List<Ville> getAllVilles();

    void deleteVilleById(Long idVille);
    
}
