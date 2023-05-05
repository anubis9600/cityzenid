package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;

public interface ProvinceService {


    ProvinceDTO saveProvince(ProvinceDTO provinceDTO);

    ProvinceDTO getProvinceById(Long idProvince) throws ProvinceNotFoundException;

    List<ProvinceDTO> getAllProvinces();

    void deleteProvinceById(Long idProvince);

    

    
}
