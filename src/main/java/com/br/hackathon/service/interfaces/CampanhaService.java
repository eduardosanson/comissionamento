package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.Campanha;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
public interface CampanhaService {
    Campanha buscarPorId(Long id);

    void deletar(Campanha campanha);
}
