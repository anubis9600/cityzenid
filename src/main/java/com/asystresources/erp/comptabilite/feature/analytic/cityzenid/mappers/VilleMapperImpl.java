package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;

@Service
public class VilleMapperImpl {
    
    public VilleDTO fromVille(Ville ville){
        VilleDTO villeDTO = new VilleDTO();
        BeanUtils.copyProperties(ville, villeDTO);

        return villeDTO;
    }
    
    public Ville fromVilleDTO(VilleDTO villeDTO){
        Ville ville = new Ville();
        BeanUtils.copyProperties(villeDTO, ville);

        return ville;
    }

}
