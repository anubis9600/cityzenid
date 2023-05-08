package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.controller;

import java.util.List;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.VilleNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.CommuneService;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.ProvinceService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.CommuneDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.VilleDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Commune;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Ville;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.ProvinceNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.VilleService;

@RestController
@RequestMapping("/communes")
public class CommuneController {
    
    private CommuneService communeService;
    private VilleService villeService;

    public CommuneController(CommuneService communeService, VilleService villeService){
        this.communeService = communeService;
        this.villeService = villeService;
    }

    @PostMapping("/save")
    public CommuneDTO saveCommune(@RequestBody Commune commune, @RequestParam(name = "villeId") Long villeId) throws ProvinceNotFoundException, VilleNotFoundException {

        return communeService.saveCommune(commune, villeId);
    }

    @GetMapping("/{id}")
    public CommuneDTO getCommuneById(@PathVariable Long id) throws VilleNotFoundException, CommuneNotFoundException {
        return communeService.getCommuneById(id);
    }

    @GetMapping
    public List<CommuneDTO> getAllCommunes() {
        return communeService.getAllCommunes();
    }

    @DeleteMapping("/{id}")
    public void deleteCommundeById(@PathVariable Long id) throws CommuneNotFoundException {
        communeService.deleteCommuneById(id);
    }

}