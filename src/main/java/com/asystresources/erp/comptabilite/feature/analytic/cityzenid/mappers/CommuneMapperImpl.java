package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.CommuneDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;

@Service
public class CommuneMapperImpl {

    private VilleMapperImpl villeMapperImpl;

    public CommuneMapperImpl(VilleMapperImpl villeMapperImpl){
        this.villeMapperImpl = villeMapperImpl;
    }
    
    public CommuneDTO fromCommune(Commune commune){
        CommuneDTO communeDTO = new CommuneDTO();
        BeanUtils.copyProperties(commune, communeDTO);
        communeDTO.setVilleDTO(villeMapperImpl.fromVille(commune.getVille()));

        return communeDTO;
    }
    
    public Commune fromCommuneDTO(CommuneDTO communeDTO){
        Commune commune = new Commune();
        BeanUtils.copyProperties(communeDTO, commune);
        commune.setVille(villeMapperImpl.fromVilleDTO(communeDTO.getVilleDTO()));

        return commune;
    }

}