package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;
import java.util.stream.Collectors;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Province;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.ProvinceMapperImpl;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.VilleMapperImpl;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.VilleRepository;

@Service
public class VilleServiceImpl implements VilleService {

    private VilleRepository villeRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    private ProvinceService provinceService;

    private VilleMapperImpl dtoVilleMapperImpl;

    private ProvinceMapperImpl dtoProvinceMapper;

    public VilleServiceImpl(ProvinceService provinceService,
                            VilleRepository villeRepository,
                            VilleMapperImpl dtoVilleMapperImpl,
                            ProvinceMapperImpl dtoProvinceMapper){
        this.provinceService = provinceService;
        this.villeRepository = villeRepository;
        this.dtoVilleMapperImpl = dtoVilleMapperImpl;
        this.dtoProvinceMapper = dtoProvinceMapper;
    }

    @Override
    public VilleDTO saveVille(Ville ville, Long provinceId) throws ProvinceNotFoundException {
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new ProvinceNotFoundException("Ce province n'existe pas"));

        ville.setProvince(province);

        Ville savedVille = villeRepository.save(ville);

        return  dtoVilleMapperImpl.fromVille(savedVille);
    }

    @Override
    public VilleDTO getVilleById(Long id) throws VilleNotFoundException {
        Ville ville = villeRepository.findById(id).orElseThrow(()-> new VilleNotFoundException("La ville est introuvable"));
        VilleDTO villeDTO = dtoVilleMapperImpl.fromVille(ville);

        return villeDTO;
    }

    @Override
    public List<VilleDTO> getAllVilles() {
        List<Ville> villes = villeRepository.findAll();
        List<VilleDTO> villeDTOList = villes.stream().map(vDTO -> dtoVilleMapperImpl.fromVille(vDTO))
                .collect(Collectors.toList());

        return villeDTOList;
    }

    @Override
    public List<VilleDTO> getVilleByProvinces(Long provinceId) throws ProvinceNotFoundException {
        ProvinceDTO provinceDTO = provinceService.getProvinceById(provinceId);

        return null;
    }

    @Override
    public void deleteVilleById(Long id) {
        villeRepository.deleteById(id);
    }


}
