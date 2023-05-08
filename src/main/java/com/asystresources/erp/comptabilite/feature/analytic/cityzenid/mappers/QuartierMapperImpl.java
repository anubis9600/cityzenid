package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.QuartierDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Quartier;

@Service
public class QuartierMapperImpl {

    private CommuneMapperImpl communeMapperImpl;

    public QuartierMapperImpl(CommuneMapperImpl communeMapperImpl){
        this.communeMapperImpl = communeMapperImpl;
    }
    
    public QuartierDTO fromQuartier(Quartier quartier){
        QuartierDTO quartierDTO = new QuartierDTO();
        BeanUtils.copyProperties(quartier, quartierDTO);
        quartierDTO.setCommuneDTO(communeMapperImpl.fromCommune(quartier.getCommune()));

        return quartierDTO;
    }
    
    public Quartier fromQuartierDTO(QuartierDTO quartierDTO){
        Quartier quartier = new Quartier();
        BeanUtils.copyProperties(quartierDTO, quartier);
        quartier.setCommune(communeMapperImpl.fromCommuneDTO(quartierDTO.getCommuneDTO()));

        return quartier;
    }

}