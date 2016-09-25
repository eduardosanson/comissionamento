package com.br.hackathon.service;

import com.br.hackathon.entity.Categoria;
import com.br.hackathon.repository.CategoriaRepository;
import com.br.hackathon.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);

    }

    @Override
    public void  delete(Categoria categoria){
        categoriaRepository.delete(categoria);
    }

    @Override
    public Categoria buscarPorId(Long id){
        return  categoriaRepository.findOne(id);
    }
}
