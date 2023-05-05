package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Province;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.mappers.ProvinceMapperImpl;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.repository.ProvinceRepository;


@Service
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceRepository provinceRepository;

    private ProvinceMapperImpl dtoProvinceMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ProvinceMapperImpl dtoProvinceMapper){
        this.provinceRepository = provinceRepository;
        this.dtoProvinceMapper = dtoProvinceMapper;
    }

    @Override
    public ProvinceDTO saveProvince(ProvinceDTO provinceDTO) {
        Province province = dtoProvinceMapper.fromProvinceDTO(provinceDTO);
        Province savedProvince = provinceRepository.save(province);
        
        return dtoProvinceMapper.fromProvince(savedProvince);
    }

    @Override
    public ProvinceDTO getProvinceById(Long idProvince) throws ProvinceNotFoundException {
        Province province = provinceRepository.findById(idProvince).orElseThrow(()-> 
                    new ProvinceNotFoundException("Ce province n'existe pas!"));

        ProvinceDTO provinceDTO = dtoProvinceMapper.fromProvince(province);

        return provinceDTO;
    }

    @Override
    public List<ProvinceDTO> getAllProvinces() {
        List<Province> provinces = provinceRepository.findAll();
        List<ProvinceDTO> provinceDTOs = provinces.stream().map(province-> dtoProvinceMapper
                                        .fromProvince(province)).collect(Collectors.toList());
        
        return provinceDTOs;
    }

    @Override
    public void deleteProvinceById(Long id) {
        provinceRepository.deleteById(id);
    }




    
}
