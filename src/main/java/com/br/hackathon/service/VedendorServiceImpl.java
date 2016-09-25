package com.br.hackathon.service;

import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.repository.VedendorRepository;
import com.br.hackathon.service.interfaces.VedendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@Service
public class VedendorServiceImpl implements VedendorService {

    @Autowired
    private VedendorRepository vedendorRepository;

    @Override
    public Vedendor buscarPorId(Long id){
        return  vedendorRepository.findOne(id);
    }

    @Override
    public void deletar(Vedendor vedendor){
        vedendorRepository.delete(vedendor);
    }

    @Override
    public  Vedendor salve(Vedendor vedendor){
        return vedendorRepository.save(vedendor);
    }




}
