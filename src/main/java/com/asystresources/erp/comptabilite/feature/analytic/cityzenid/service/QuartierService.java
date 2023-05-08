package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.QuartierDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Quartier;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.QuartierNotFoundException;

public interface QuartierService {
    
    QuartierDTO saveQuartier(Quartier quartier, Long communeId) throws QuartierNotFoundException, CommuneNotFoundException;

    QuartierDTO getQuartierById(Long quartierId) throws QuartierNotFoundException;

    List<QuartierDTO> getAllQuartier();

    String deleteQuartierById(Long quartierId) throws QuartierNotFoundException;
    
}
