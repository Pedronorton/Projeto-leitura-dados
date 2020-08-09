package com.projetos.processamentodados.config;

import com.projetos.processamentodados.service.AdquirenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.text.ParseException;

@Configuration
public class DevConfig {

    @Autowired
    AdquirenteService service;

    @Bean
    public boolean instantiateDatabase() throws ParseException, FileNotFoundException {

        service.AdquirenteService();
        return true;
    }
}
