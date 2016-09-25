package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.Loja;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
public interface LojaService {
    Loja save(Loja loja);

    Loja buscarPorEc(String ec);

    Loja buscarPorId(Long id);
}
