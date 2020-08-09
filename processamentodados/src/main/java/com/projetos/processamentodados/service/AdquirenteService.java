package com.projetos.processamentodados.service;


import com.projetos.processamentodados.domain.Detalhe;
import com.projetos.processamentodados.domain.Header;
import com.projetos.processamentodados.domain.Trailler;
import com.projetos.processamentodados.util.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AdquirenteService {
    Header headerArquivo;
    Trailler traillerArquivo;
    List<Detalhe> listaVendas = new ArrayList<>();

    @Autowired
    DateConversion dateConversion;
    @Autowired
    HeaderService headerService;
    @Autowired
    TraillerService traillerService;
    @Autowired
    DetalheService detalheService;

    public void AdquirenteService() throws FileNotFoundException {
        try{
            FileReader arquivo = new FileReader("src/main/java/com/projetos/processamentodados/arquivos/dados2.txt");
            BufferedReader bufferedReaderArquivo = new BufferedReader(arquivo);
            String registro = bufferedReaderArquivo.readLine();
            while(registro != null) {
                int tipoRegistro = verificaRegistro(registro);
                if(tipoRegistro == 0 ) {
                    headerArquivo = headerService.montarHeader(registro);
                }
                else if (tipoRegistro == 1) {
                    Detalhe venda = detalheService.montarVenda(registro);

                    listaVendas.add(venda);
                }else if(tipoRegistro == 9) {
                    traillerArquivo =  traillerService.montarTrailler(registro);
                }
                else if(tipoRegistro == -1) {
                    System.out.println("Erro na leitura");
                }

                registro = bufferedReaderArquivo.readLine();
            }
            bufferedReaderArquivo.close();
        }catch (IOException | ParseException e){
            throw new RuntimeException("Erro ao abrir o arquivo");
        }

    }
    public List getLista(){
        return listaVendas;
    }

    public Header getHeader(){
        return headerArquivo;
    }
    public Integer verificaRegistro(String registro) {
        return Integer.parseInt(registro.split("")[0]);
    }

}
