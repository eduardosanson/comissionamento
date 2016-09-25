package com.br.hackathon.controller;

import com.br.hackathon.entity.Campanha;
import com.br.hackathon.service.interfaces.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@RestController
@RequestMapping("/campanha")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable Long id){
        Campanha campanha = campanhaService.buscarPorId(id);

        campanhaService.deletar(campanha);

        return ResponseEntity.noContent().build();

    }


}
