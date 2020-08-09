package com.projetos.processamentodados.service;

import com.projetos.processamentodados.domain.Detalhe;
import com.projetos.processamentodados.repositories.DetalheRepository;
import com.projetos.processamentodados.util.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DetalheService {

    @Autowired
    DateConversion dateConversion;

    @Autowired
    DetalheRepository repo;

    public Detalhe montarVenda(String registro) throws ParseException {
        DateFormat data = new SimpleDateFormat("yyyyMMdd");
        Integer tipoRegistro = Integer.parseInt(registro.substring(0,1));
        Integer estabelecimento = Integer.parseInt(registro.substring(1,11));
        Date dataInicialTransacao = data.parse(registro.substring(11,19));
        Date dataEvento =  data.parse(registro.substring(19, 27));
        Calendar horaEvento = dateConversion.stringHourToCalendar(registro.substring(27, 33));
        Integer tipoEvento = Integer.parseInt(registro.substring(33,35));
        Integer tipoTransicao = Integer.parseInt(registro.substring(35,37));
        String numeroSeriaLeitor = registro.substring(37,45);
        String codTransacao = registro.substring(45,77);
        String codPedido = registro.substring(77,97);
        Long valorTotalTransacao = Long.parseLong(registro.substring(97,110));
        Long valorParcela = Long.parseLong(registro.substring(110,123));
        String pagamento = registro.substring(123,124);
        String plano = registro.substring(124,126);
        String parcela = registro.substring(126,128);
        Integer qtdParcela = Integer.parseInt(registro.substring(128,130));
        Calendar dataPrevistaPagamento = dateConversion.stringToCalendar(registro.substring(130,138));
        Long taxaParcelamentoComprador = Long.parseLong(registro.substring(138,151));
        Long tarifaBoleto = Long.parseLong(registro.substring(151,164));
        Long valorOriginalTransacao = Long.parseLong(registro.substring(164,177));
        Long taxaParcelamentoVendedor = Long.parseLong(registro.substring(177,190));
        Long taxaIntermediacao = Long.parseLong(registro.substring(190,203));
        Long tarifaIntermediacao = Long.parseLong(registro.substring(203,216));
        Long tarifaBoletoVendedor = Long.parseLong(registro.substring(216,229));
        Long repasseAplicacao = Long.parseLong(registro.substring(229,242));
        Long valorLiquidoTransacao  = Long.parseLong(registro.substring(242,255));
        Integer statusPagamento = Integer.parseInt(registro.substring(255,257));
        String filler = registro.substring(257,259);
        Integer meioPagamento = Integer.parseInt(registro.substring(259,261));
        String instituicaoFinanceira = registro.substring(261,291);
        String canalEntrada = registro.substring(291,293);
        Integer leitor = Integer.parseInt(registro.substring(293,295));
        Integer meioCaptura = Integer.parseInt(registro.substring(295,297));
        String numeroLogico = registro.substring(297,329);
        String nsu = registro.substring(329,340);
        filler = registro.substring(340,343);
        String cartaoBin = registro.substring(343,349);
        String cartaoHolder = registro.substring(349,353);
        String codAutorizacao = registro.substring(353,359);
        String codCV = registro.substring(359,391);
        String usoFuturo = registro.substring(391,530);


        Detalhe venda = new Detalhe(tipoRegistro, estabelecimento, dataInicialTransacao, dataEvento, horaEvento, tipoEvento, tipoTransicao, numeroSeriaLeitor, codTransacao,
                codPedido,valorTotalTransacao, valorParcela, pagamento,plano ,parcela ,qtdParcela,dataPrevistaPagamento, taxaParcelamentoComprador, tarifaBoleto,valorOriginalTransacao,
                taxaParcelamentoVendedor, taxaIntermediacao, tarifaIntermediacao,tarifaBoletoVendedor, repasseAplicacao, valorLiquidoTransacao, statusPagamento,filler,
                meioPagamento, instituicaoFinanceira, canalEntrada, leitor, meioCaptura, numeroLogico, nsu, filler, cartaoBin, cartaoHolder, codAutorizacao, codCV, usoFuturo   );

        repo.save(venda);
        return venda;
    }

    public List<Detalhe> getByInstituicao(String instituicao){
        return repo.findByinstituicaoFinanceira(instituicao);
    }

}
