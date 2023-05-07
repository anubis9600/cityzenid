package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;

@Service
public class VilleMapperImpl {

    private ProvinceMapperImpl provinceMapper;

    public VilleMapperImpl(ProvinceMapperImpl provinceMapper){
        this.provinceMapper = provinceMapper;
    }
    
    public VilleDTO fromVille(Ville ville){
        VilleDTO villeDTO = new VilleDTO();
        BeanUtils.copyProperties(ville, villeDTO);
        villeDTO.setProvinceDTO(provinceMapper.fromProvince(ville.getProvince()));

        return villeDTO;
    }
    
    public Ville fromVilleDTO(VilleDTO villeDTO){
        Ville ville = new Ville();
        BeanUtils.copyProperties(villeDTO, ville);
        ville.setProvince(provinceMapper.fromProvinceDTO(villeDTO.getProvinceDTO()));

        return ville;
    }

}
