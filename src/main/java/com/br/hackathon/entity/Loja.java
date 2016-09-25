package com.br.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Gerencia-RJ on 25/09/2016.
 */
@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String ec;

    @JsonIgnore
    @OneToMany(mappedBy = "loja",cascade =CascadeType.ALL )
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "loja",cascade = CascadeType.ALL)
    private List<Vedendor> vedendores;

    @OneToOne(cascade = CascadeType.ALL)
    private Admin admin;

    @OneToMany(mappedBy = "loja",cascade = CascadeType.ALL)
    private List<Campanha> campanhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Vedendor> getVedendores() {
        return vedendores;
    }

    public void setVedendores(List<Vedendor> vedendores) {
        this.vedendores = vedendores;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Campanha> getCampanhas() {
        return campanhas;
    }

    public void setCampanhas(List<Campanha> campanhas) {
        this.campanhas = campanhas;
    }
}