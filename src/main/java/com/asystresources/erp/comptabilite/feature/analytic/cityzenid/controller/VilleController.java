package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.controller;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.ProvinceService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleController {
    
    private VilleService villeService;
    private ProvinceService provinceService;

    public VilleController(VilleService villeService, ProvinceService provinceService){
        this.villeService = villeService;
        this.provinceService = provinceService;
    }

    @PostMapping("/save")
    public VilleDTO saveVille(@RequestBody Ville ville, @RequestParam(name = "provinceId") Long provinceId) throws ProvinceNotFoundException {

        return villeService.saveVille(ville, provinceId);
    }

    @GetMapping("/{id}")
    public VilleDTO getVilleById(@PathVariable Long id) throws VilleNotFoundException {
        return villeService.getVilleById(id);
    }

    @GetMapping
    public List<VilleDTO> getAllVilles() {
        return villeService.getAllVilles();
    }

    public List<VilleDTO> getVilleByProvinces(Long provinceId) throws ProvinceNotFoundException {
        return villeService.getVilleByProvinces(provinceId);
    }

    @DeleteMapping("/{id}")
    public void deleteVilleById(@PathVariable Long id) {
        villeService.deleteVilleById(id);
    }

}