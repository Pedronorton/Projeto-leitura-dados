package com.projetos.processamentodados.resource;


import com.projetos.processamentodados.domain.Detalhe;
import com.projetos.processamentodados.repositories.DetalheRepository;
import com.projetos.processamentodados.service.AdquirenteService;
import com.projetos.processamentodados.service.DetalheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/detalhes")
public class DetalheResource {

    @Autowired
    AdquirenteService adquirenteService;

    @Autowired
    DetalheService service;

    @Autowired
    DetalheRepository repo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllResource() throws FileNotFoundException {

        List<Detalhe> listaVendas = adquirenteService.getLista();
        return ResponseEntity.ok().body(listaVendas);
    }
    @RequestMapping(value = "/{instiuicao}", method = RequestMethod.GET)
    public ResponseEntity<?> getByinstituicaoFinanceira(@PathVariable String instiuicao) {

        List<Detalhe> listaVendas = service.getByInstituicao(instiuicao);
        return ResponseEntity.ok().body(listaVendas);
    }

    @RequestMapping(value = "/parcelas", method = RequestMethod.GET)
    public ResponseEntity<?> getByDebito(@RequestParam String tipoPagamento) {
        List<Detalhe> listaVendas = new ArrayList<>();

        Integer flagPagamento;
        if(tipoPagamento.equals("debito")){
            flagPagamento = 0;
            System.out.println("debito");
             listaVendas = repo.findByVista(flagPagamento);
        }else if(tipoPagamento.equals("credito")){
            flagPagamento = 1;
            listaVendas = repo.findByVista(flagPagamento);
        }else if (tipoPagamento.equals("prazo")) {
             listaVendas = repo.findByPrazo();
        }
        return ResponseEntity.ok().body(listaVendas);
    }
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity<?> getByData(@RequestParam String dataInicio, @RequestParam String dataFim) throws ParseException {

        DateFormat dateFornmat = new SimpleDateFormat("yyyyMMdd");
        Date inicio = dateFornmat.parse(dataInicio);
        Date fim = dateFornmat.parse(dataFim);

        List<Detalhe> listaVendas = repo.findByDate(inicio, fim);

        return ResponseEntity.ok().body(listaVendas);
    }


}
