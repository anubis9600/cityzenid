package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Province;

@Service
public class ProvinceMapperImpl {
    
    public ProvinceDTO fromProvince(Province province){
        ProvinceDTO provinceDTO = new ProvinceDTO();
        BeanUtils.copyProperties(province, provinceDTO);

        return provinceDTO;
    }

    public Province fromProvinceDTO(ProvinceDTO provinceDTO){
        Province province = new Province();
        BeanUtils.copyProperties(provinceDTO, province);

        return province;
    }
    
}
