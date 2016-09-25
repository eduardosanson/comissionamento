package com.br.hackathon.repository;

import com.br.hackathon.entity.Loja;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */

public interface LojaRepositrory extends CrudRepository<Loja,Long> {

    Loja findByEc(String ec);
}
