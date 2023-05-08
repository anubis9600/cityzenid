package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.ProvinceDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.ProvinceService;

@RestController
@RequestMapping("provinces")
public class ProvinceController {
    
    private ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService){
        this.provinceService = provinceService;
    }

    @PostMapping
    public ProvinceDTO saveProvince(@RequestBody ProvinceDTO provinceDTO) {
        return provinceService.saveProvince(provinceDTO);
    }

    @GetMapping("/getprovinces")
    List<ProvinceDTO> getAllProvinces(){
        return provinceService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public ProvinceDTO getProvinceById(@PathVariable("id") Long IdProvince) throws ProvinceNotFoundException {
        ProvinceDTO provinceDTO = provinceService.getProvinceById(IdProvince);
        return provinceDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteProvinceById(@PathVariable Long id) {
        provinceService.deleteProvinceById(id);
    }

}