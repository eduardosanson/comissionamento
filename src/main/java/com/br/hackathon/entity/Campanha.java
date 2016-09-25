package com.br.hackathon.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@Entity
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Double comissaoAdicional;

    private Date inicio;

    private Date fim;

    private Date registrado;

    @ManyToOne(cascade = CascadeType.ALL)
    private Loja loja;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Date getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Date registrado) {
        this.registrado = registrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getComissaoAdicional() {
        return comissaoAdicional;
    }

    public void setComissaoAdicional(Double comissaoAdicional) {
        this.comissaoAdicional = comissaoAdicional;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
