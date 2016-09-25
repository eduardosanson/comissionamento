package com.br.hackathon.controller;

import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.service.interfaces.VedendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@RestController
@RequestMapping("/vedendor")
public class VedendorController {

    @Autowired
    private VedendorService vedendorService;

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        Vedendor vedendor = vedendorService.buscarPorId(id);

        vedendorService.deletar(vedendor);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity salvar(@PathVariable Long id, @RequestBody Vedendor vedendor){
        Vedendor vedendorPersistido = vedendorService.buscarPorId(id);

        vedendorPersistido.setCpf(vedendor.getCpf());
        vedendorPersistido.setLoja(vedendor.getLoja());
        vedendorPersistido.setMetas(vedendor.getMetas());
        vedendorPersistido.setNome(vedendor.getNome());

        vedendorService.salve(vedendorPersistido);

        return ResponseEntity.noContent().build();

    }


}
