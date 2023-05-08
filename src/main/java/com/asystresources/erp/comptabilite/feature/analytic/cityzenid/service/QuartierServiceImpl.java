package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;
import java.util.stream.Collectors;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.CommuneRepository;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.QuartierRepository;

import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.QuartierDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Quartier;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.QuartierNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.QuartierMapperImpl;

@Service
public class QuartierServiceImpl implements QuartierService {

    private QuartierRepository quartierRepository;
    private CommuneRepository communeRepository;
    private QuartierMapperImpl dtoQuartierMapperImpl;

    public QuartierServiceImpl(QuartierRepository quartierRepository,
                                CommuneRepository communeRepository,
                                QuartierMapperImpl dtoQuartierMapperImpl){
        this.quartierRepository = quartierRepository;
        this.communeRepository = communeRepository;
        this.dtoQuartierMapperImpl = dtoQuartierMapperImpl;
    }

    @Override
    public QuartierDTO saveQuartier(Quartier quartier, Long communeId) throws CommuneNotFoundException  {
        Commune commune = communeRepository.findById(communeId).orElseThrow(() ->new CommuneNotFoundException("Ce Commune n'existe pas"));
        quartier.setCommune(commune);
        Quartier savedQuartier = quartierRepository.save(quartier);

        return dtoQuartierMapperImpl.fromQuartier(savedQuartier);
    }

    @Override
    public QuartierDTO getQuartierById(Long idQuartier) throws QuartierNotFoundException {
        Quartier quartier = quartierRepository.findById(idQuartier).orElseThrow(() -> new QuartierNotFoundException("Ce quartier n'existe pas"));

        return dtoQuartierMapperImpl.fromQuartier(quartier);
    }

    @Override
    public List<QuartierDTO> getAllQuartier() {
        List<Quartier> quartiers = quartierRepository.findAll();
        List<QuartierDTO> quartierDTOs = quartiers.stream().map(qtrs -> dtoQuartierMapperImpl.fromQuartier(qtrs)).collect(Collectors.toList());

        return quartierDTOs;
    }

    @Override
    public String deleteQuartierById(Long quartierId) throws QuartierNotFoundException {
        Quartier quartier = quartierRepository.findById(quartierId).orElseThrow(()-> new QuartierNotFoundException("Ce quartier n'existe pa"));
        quartierRepository.delete(quartier);
        return "Quartier: " +quartier.getDesignation()+ " supprimee"; 
    }


}