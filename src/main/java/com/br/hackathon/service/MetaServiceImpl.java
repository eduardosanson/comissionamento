package com.br.hackathon.service;

import com.br.hackathon.entity.Meta;
import com.br.hackathon.repository.MetaRepository;
import com.br.hackathon.service.interfaces.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Override
    public void deletar(Meta meta){
        metaRepository.delete(meta);
    }

    @Override
    public Meta buscarPorId(Long id){
        return metaRepository.findOne(id);
    }
}
