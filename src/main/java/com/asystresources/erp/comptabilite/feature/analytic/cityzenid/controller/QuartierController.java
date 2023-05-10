package com.asystresources.erp.comptabilite.feature.analytic.cityzenid.controller;

import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.dto.QuartierDTO;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.entity.Quartier;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.CommuneNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.exceptions.QuartierNotFoundException;
import com.asystresources.erp.comptabilite.feature.analytic.cityzenid.service.QuartierService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartiers")
public class QuartierController {
    
    private QuartierService quartierService;

    public QuartierController(QuartierService quartierService){
        this.quartierService = quartierService;
    }

    @PostMapping("/save")
    public QuartierDTO saveQuartier(@RequestBody Quartier quartier, @RequestParam Long communeId) throws QuartierNotFoundException, CommuneNotFoundException {
        
        return quartierService.saveQuartier(quartier, communeId);
    }

    @GetMapping("/{quartierId}")
    public QuartierDTO getQuartierById(@PathVariable Long quartierId) throws QuartierNotFoundException{
        return quartierService.getQuartierById(quartierId);
    }

    @GetMapping                            
    public List<QuartierDTO> getAllQuartier(){
        return quartierService.getAllQuartier();
    }

    // String deleteQuartierById(Long idCommune) throws QuartierNotFoundException;
    



}