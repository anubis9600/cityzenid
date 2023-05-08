package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;

public interface VilleService {
    
    VilleDTO saveVille(Ville ville, Long provinceId) throws ProvinceNotFoundException;

    VilleDTO getVilleById(Long idVille) throws VilleNotFoundException;

    List<VilleDTO> getAllVilles();

    // List<VilleDTO> getVilleByProvinces(Long provinceId) throws ProvinceNotFoundException;

    void deleteVilleById(Long idVille);
    
}
