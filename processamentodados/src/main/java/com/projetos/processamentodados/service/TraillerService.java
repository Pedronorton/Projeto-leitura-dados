package com.projetos.processamentodados.service;

import com.projetos.processamentodados.domain.Trailler;
import com.projetos.processamentodados.repositories.TraillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraillerService {
    @Autowired
    TraillerRepository repo;




    public Trailler montarTrailler(String registro){
        Integer tipoRegistro = Integer.parseInt(registro.substring(0,1));
        Integer totalRegistro = Integer.parseInt(registro.substring(1,12));
        String usoFuturo = registro.substring(12,12);
        Trailler traillerArquivo = new Trailler(tipoRegistro, totalRegistro, usoFuturo);
        System.out.println(traillerArquivo);
        repo.save(traillerArquivo);
        return traillerArquivo;
    }
}
