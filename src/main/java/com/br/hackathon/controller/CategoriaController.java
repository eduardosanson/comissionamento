package com.br.hackathon.controller;

import com.br.hackathon.entity.Categoria;
import com.br.hackathon.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity alterar(@PathVariable Long id, @RequestBody Categoria categoria){

        categoriaService.save(categoria);

        return ResponseEntity.accepted().build();

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity alterar(@PathVariable Long id){
        Categoria categoria = categoriaService.buscarPorId(id);
        categoriaService.delete(categoria);

        return ResponseEntity.noContent().build();

    }


}
