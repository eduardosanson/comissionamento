package com.br.hackathon.service;

import com.br.hackathon.entity.Campanha;
import com.br.hackathon.repository.CampanhaRepository;
import com.br.hackathon.service.interfaces.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@Service
public class CampanhaServiceImpl implements CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @Override
    public Campanha buscarPorId(Long id){

        return campanhaRepository.findOne(id);

    }

    @Override
    public void deletar(Campanha campanha){
        campanhaRepository.delete(campanha);
    }
}
