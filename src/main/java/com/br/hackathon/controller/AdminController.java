package com.br.hackathon.controller;

import com.br.hackathon.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity cadastrar(){

        return ResponseEntity.accepted().build();
    }

    @RequestMapping(value = "/meta",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity cadastrarMeta(@RequestBody com.br.hackathon.entity.Meta meta){

        adminService.cadastrarMeta(meta);

        return ResponseEntity.accepted().build();

    }




}
