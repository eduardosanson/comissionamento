package com.br.hackathon.repository;

import com.br.hackathon.entity.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */

public interface AdminRepository extends CrudRepository<Admin,Long> {

 Admin findBySenha(String senha);
}
