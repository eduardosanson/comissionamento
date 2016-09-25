package com.br.hackathon.repository;

import com.br.hackathon.entity.Venda;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
public interface VendaRepository extends CrudRepository<Venda,Long> {

    List<Venda> findByVedendorIdAndRegistradoBetween(Long id, Date ini, Date fim);
}
