package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.controller;

import java.util.List;

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

    public VilleController(VilleService villeService){
        this.villeService = villeService;
    }

    @PostMapping("/save")
    public VilleDTO saveVille(@RequestBody VilleDTO villeDTO, @RequestParam(name = "province") Long provinceId) throws ProvinceNotFoundException {
        
        return villeService.saveVille(villeDTO, provinceId);
    }

    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable Long id) {
        return villeService.getVilleById(id);
    }

    @GetMapping
    public List<Ville> getAllVilles() {
        return villeService.getAllVilles();
    }

    @DeleteMapping("/{id}")
    public void deleteVilleById(@PathVariable Long id) {
        villeService.deleteVilleById(id);
    }

}