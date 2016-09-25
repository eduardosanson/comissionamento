package com.br.hackathon.service.interfaces;

import com.br.hackathon.entity.ItemVenda;
import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.entity.Venda;

import java.util.Date;
import java.util.List;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
public interface VedendorService {
    Vedendor buscarPorId(Long id);

    void deletar(Vedendor vedendor);

    Vedendor salve(Vedendor vedendor);

    void criaVenda(Vedendor vedendor, List<ItemVenda> itens);

    List<Venda> buscarVendas(Long id, Date ini, Date fim);
}
