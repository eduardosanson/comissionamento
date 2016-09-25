package com.br.hackathon.controller;

import com.br.hackathon.entity.ItemVenda;
import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.entity.Venda;
import com.br.hackathon.service.interfaces.VedendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

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

    @RequestMapping(method = RequestMethod.POST,value = "/{id}/venda/itens")
    public ResponseEntity salvarVenda(@PathVariable Long id, @RequestBody List<ItemVenda> itens){
        Vedendor vedendor = vedendorService.buscarPorId(id);

        vedendorService.criaVenda(vedendor,itens);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}/venda")
    private ResponseEntity<List<Venda>> buscarVendas(@PathVariable Long id,  @RequestParam("ini")Date ini, @RequestParam("fim") Date fim){

        List<Venda> vendas = vedendorService.buscarVendas(id,ini,fim);

        return ResponseEntity.ok(vendas);

    }


}
