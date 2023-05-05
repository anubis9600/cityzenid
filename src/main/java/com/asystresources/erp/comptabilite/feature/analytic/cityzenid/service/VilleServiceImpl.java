package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

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
    public VilleDTO saveVille(VilleDTO villeDTO, Long provinceId) throws ProvinceNotFoundException {

        ProvinceDTO provinceDTO = provinceService.getProvinceById(provinceId);
        Province province = dtoProvinceMapper.fromProvinceDTO(provinceDTO);

        Ville ville = dtoVilleMapperImpl.fromVilleDTO(villeDTO);
        villeDTO.setProvinceDTO(dtoProvinceMapper.fromProvince(province));
        Ville savedVille = villeRepository.save(ville);
        
        return dtoVilleMapperImpl.fromVille(savedVille);
    }

    @Override
    public Ville getVilleById(Long id) {
        return villeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    @Override
    public void deleteVilleById(Long id) {
        villeRepository.deleteById(id);
    }



    
}
