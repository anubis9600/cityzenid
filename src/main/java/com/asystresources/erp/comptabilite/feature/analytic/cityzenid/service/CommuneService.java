package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.CommuneDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;

public interface CommuneService {
    
    CommuneDTO saveCommune(Commune commune, Long villeId) throws ProvinceNotFoundException, VilleNotFoundException;

    CommuneDTO getCommuneById(Long idCommune) throws VilleNotFoundException, CommuneNotFoundException;

    List<CommuneDTO> getAllCommunes();

    String deleteCommuneById(Long idCommune) throws CommuneNotFoundException;
    
}
