package com.projetos.processamentodados.service;


import com.projetos.processamentodados.domain.Header;
import com.projetos.processamentodados.repositories.HeaderRepository;
import com.projetos.processamentodados.util.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class HeaderService {
    @Autowired
    DateConversion dateConversion;

    @Autowired
    HeaderRepository repo;

    public Header montarHeader(String registro) throws ParseException {
        DateFormat data = new SimpleDateFormat("yyyyMMdd");

        Integer tipoRegistro = Integer.parseInt(registro.substring(0,1));
        Long estabelecimento = Long.parseLong(registro.substring(1,11));

        Date dataProcessamento = data.parse(registro.substring(11,19));
        Calendar periodoInicial = dateConversion.stringToCalendar(registro.substring(19,27));
        Calendar periodoFinal = dateConversion.stringToCalendar(registro.substring(27,35));
        Integer sequencia = Integer.parseInt(registro.substring(35,42));
        String empresaAdquirinte = registro.substring(42,47);
        Integer tipoExtrato = Integer.parseInt(registro.substring(47,49));
        String filler = registro.substring(49,71);
        String versaoLayout = registro.substring(70,75);
        String versaoRelease = registro.substring(73,78);
//        String usoFuturo = registro.substring(79,529);

        Header headerArquivo = new Header(tipoRegistro, estabelecimento, dataProcessamento, periodoInicial, periodoFinal, sequencia, empresaAdquirinte, tipoExtrato, filler, versaoLayout,
                versaoRelease) ;
        repo.save(headerArquivo);
        System.out.println("-------------------------------------");
        System.out.println(headerArquivo);
        return headerArquivo;
    }
}
