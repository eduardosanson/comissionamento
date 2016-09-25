package com.br.hackathon.service;

import com.br.hackathon.entity.ItemVenda;
import com.br.hackathon.entity.Vedendor;
import com.br.hackathon.entity.Venda;
import com.br.hackathon.repository.VedendorRepository;
import com.br.hackathon.service.interfaces.VedendorService;
import com.br.hackathon.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@Service
public class VedendorServiceImpl implements VedendorService {

    @Autowired
    private VedendorRepository vedendorRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public Vedendor buscarPorId(Long id){
        return  vedendorRepository.findOne(id);
    }

    @Override
    public void deletar(Vedendor vedendor){
        vedendorRepository.delete(vedendor);
    }

    @Override
    public  Vedendor salve(Vedendor vedendor){
        return vedendorRepository.save(vedendor);
    }

    @Override
    public void criaVenda(Vedendor vedendor, List<ItemVenda> itens){
        Venda venda = new Venda();

        venda.setRegistrado(new Date());
        venda.setItens(itens);
        vedendor.getVenda().add(venda);

        vedendorRepository.save(vedendor);
    }

    @Override
    public List<Venda> buscarVendas(Long id, Date ini, Date fim){

        return vendaRepository.findByVedendorIdAndRegistradoBetween(id,ini,fim);

    }




}
