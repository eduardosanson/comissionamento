package com.br.hackathon.controller;

import com.br.hackathon.entity.Meta;
import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.service.interfaces.MetaService;
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
@RequestMapping("/meta")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Meta meta = metaService.buscarPorId(id);

        metaService.deletar(meta);

        return ResponseEntity.noContent().build();

    }


}
