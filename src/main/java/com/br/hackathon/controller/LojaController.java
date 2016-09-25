package com.br.hackathon.controller;

import com.br.hackathon.config.Hateoas;
import com.br.hackathon.entity.*;
import com.br.hackathon.service.interfaces.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@RestController
@RequestMapping("/loja")
public class LojaController {

    public static String DOMAIN="/loja";

    @Autowired
    private Hateoas hateoas;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private AdminController adminController;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity cadastrar(@RequestBody Loja loja) throws URISyntaxException {
        Long id = lojaService.save(loja).getId();

        URI uri = new URI(hateoas.getServer()+DOMAIN+"/"+id);

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Loja> buscarPorEc(@RequestParam("ec") String ec){

        return ResponseEntity.ok(lojaService.buscarPorEc(ec));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Loja> buscar(@PathVariable Long id){

        System.out.println(id);

        return ResponseEntity.ok(lojaService.buscarPorId(id));

    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/admin")
    public ResponseEntity cadastrarAdmin(@PathVariable Long id, @RequestBody Admin admin) throws URISyntaxException {

        Loja loja = lojaService.buscarPorId(id);

        URI uri = new URI(hateoas.getServer()+hateoas.getAdmin().replace("{id}",loja.getId().toString()));

        loja.setAdmin(admin);

        lojaService.save(loja);

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/admin/auth")
    public ResponseEntity cadastrarAdmin(@PathVariable Long id, @RequestParam String senha) throws URISyntaxException {

        Loja loja = lojaService.buscarPorId(id);

        if (!loja.getAdmin().getSenha().equals(senha)){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/admin")
    public ResponseEntity<Admin> buscarAdmin(@PathVariable Long id){

        Loja loja = lojaService.buscarPorId(id);

        return ResponseEntity.ok(loja.getAdmin());

    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/categoria")
    public ResponseEntity cadastrarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) throws URISyntaxException {

        Loja loja = lojaService.buscarPorId(id);

        loja.getCategorias().add(categoria);

        lojaService.save(loja);

        URI uri = new URI(hateoas.getServer()+hateoas.getCategoria().replace("{id}",loja.getId().toString()));

        return ResponseEntity.created(uri).build();

    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}/categoria")
    public ResponseEntity<List<Categoria>> buscarCategoria(@PathVariable Long id) throws URISyntaxException {

        Loja loja = lojaService.buscarPorId(id);

        return ResponseEntity.ok(loja.getCategorias());

    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/campanha")
    public ResponseEntity cadastrarCategoria(@PathVariable Long id, @RequestBody Campanha campanha) throws URISyntaxException {

        Loja loja = lojaService.buscarPorId(id);

        loja.getCampanhas().add(campanha);

        lojaService.save(loja);

        URI uri = new URI(hateoas.getServer()+hateoas.getCampanha().replace("{id}",loja.getId().toString()));

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/campanha")
    public ResponseEntity<List<Campanha>> buscarCampanha(@PathVariable Long id){

        Loja loja = lojaService.buscarPorId(id);

        return ResponseEntity.ok(loja.getCampanhas());

    }

    @RequestMapping(method = RequestMethod.POST,value = "/{id}/vedendor")
    public ResponseEntity cadastrarVedendor(@RequestBody Vedendor vedendor, @PathVariable Long id) throws URISyntaxException {
        Loja loja = lojaService.buscarPorId(id);

        loja.getVedendores().add(vedendor);

        lojaService.save(loja);

        URI uri = new URI(hateoas.getServer()+hateoas.getVedendor().replace("{id}",loja.getId().toString()));

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}/vedendor")
    public ResponseEntity<List<Vedendor>> buscarVedendores(@PathVariable Long id) throws URISyntaxException {
        Loja loja = lojaService.buscarPorId(id);

        return ResponseEntity.ok(loja.getVedendores());
    }


}
