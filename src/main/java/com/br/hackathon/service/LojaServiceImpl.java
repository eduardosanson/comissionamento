package com.br.hackathon.service;

import com.br.hackathon.entity.Admin;
import com.br.hackathon.entity.Loja;
import com.br.hackathon.repository.AdminRepository;
import com.br.hackathon.repository.LojaRepositrory;
import com.br.hackathon.service.interfaces.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    private LojaRepositrory repositrory;

    @Override
    public Loja save(Loja loja){

        return repositrory.save(loja);

    }

    @Override
    public Loja buscarPorEc(String ec){

        return repositrory.findByEc(ec);

    }

    @Override
    public Loja buscarPorId(Long id){

        return repositrory.findOne(id);

    }

}
