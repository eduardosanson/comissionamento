package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.Categoria;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
public interface CategoriaService {
    Categoria save(Categoria categoria);

    void  delete(Categoria categoria);

    Categoria buscarPorId(Long id);
}
