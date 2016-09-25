package com.br.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Gerencia-RJ on 24/09/2016.
 */
@SpringBootApplication
public class ComissionamentoApp {

    public static void main(String ...args){
        SpringApplication.run(ComissionamentoApp.class,args);
    }

    public boolean checkApp() {
        return true;
    }
}
