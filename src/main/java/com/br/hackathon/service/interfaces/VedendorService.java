package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.Vedendor;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
public interface VedendorService {
    Vedendor buscarPorId(Long id);

    void deletar(Vedendor vedendor);

    Vedendor salve(Vedendor vedendor);
}
