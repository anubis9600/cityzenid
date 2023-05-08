package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;
import java.util.stream.Collectors;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.CommuneRepository;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.CommuneDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Province;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.CommuneMapperImpl;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.VilleMapperImpl;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.VilleRepository;

@Service
public class CommuneServiceImpl implements CommuneService {

    private CommuneRepository communeRepository;
    private VilleRepository villeRepository;
    private CommuneMapperImpl dtCommuneMapperImpl;

    public CommuneServiceImpl(CommuneRepository communeRepository,
                            VilleRepository villeRepository,
                            CommuneMapperImpl dtCommuneMapperImpl){
        this.villeRepository = villeRepository;
        this.communeRepository = communeRepository;
        this.dtCommuneMapperImpl = dtCommuneMapperImpl;
    }

    @Override
    public CommuneDTO saveCommune(Commune commune, Long villeId) throws VilleNotFoundException {
        Ville ville = villeRepository.findById(villeId).orElseThrow(() -> new VilleNotFoundException("Cette Ville n'existe pas"));

        commune.setVille(ville);

        Commune savedCommune = communeRepository.save(commune);

        return  dtCommuneMapperImpl.fromCommune(savedCommune);
    }

    @Override
    public CommuneDTO getCommuneById(Long idCommune) throws CommuneNotFoundException {
        Commune commune = communeRepository.findById(idCommune).orElseThrow(() -> new CommuneNotFoundException("Ce Commune n'existe pas"));
        return dtCommuneMapperImpl.fromCommune(commune);
    }

    @Override
    public List<CommuneDTO> getAllCommunes() {
        List<Commune> communes = communeRepository.findAll();
        List<CommuneDTO> communeDTOs = communes.stream().map(coms -> dtCommuneMapperImpl.fromCommune(coms)).collect(Collectors.toList());
        return communeDTOs;
    }

    @Override
    public String deleteCommuneById(Long idCommune) throws CommuneNotFoundException {
        Commune commune = communeRepository.findById(idCommune).orElseThrow(() -> new CommuneNotFoundException("Ce Commune n'existe pas"));
        communeRepository.delete(commune);

        return "Commune: " +commune.getDesignation()+ " supprimee";
    }

}