package com.br.hackathon.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date registrado;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ItemVenda> itens;

    @ManyToOne
    private Vedendor vedendor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Date registrado) {
        this.registrado = registrado;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Vedendor getVedendor() {
        return vedendor;
    }

    public void setVedendor(Vedendor vedendor) {
        this.vedendor = vedendor;
    }
}
