package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.Meta;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
public interface MetaService {
    void deletar(Meta meta);

    Meta buscarPorId(Long id);
}
