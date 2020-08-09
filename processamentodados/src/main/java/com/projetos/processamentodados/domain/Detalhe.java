package com.projetos.processamentodados.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Detalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoRegistro;
    private	Integer estabelecimento;
    @Temporal(TemporalType.DATE)
    private Date dataInicialTransacao;
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    private Calendar horaEvento;
    private Integer tipoEvento;
    private	Integer tipoTransacao;
    private String numeroSerieLeitor;
    private String codTransacao;
    private String codPedido;
    private	Long valorTotalTransacao;
    private Long valorParcela;
    private String pagamento;
    private String plano;
    private	String parcela;
    private Integer qtdParcela;
    private Calendar dataPrevistaPagamento;
    private Long taxaParcelamentoComprador;
    private	Long tarifaBoleto;
    private Long valorOriginalTransacao;
    private Long taxaParcelamentoVendedor;
    private	Long taxaIntermediacao;
    private Long tarifaIntermediacao;
    private Long tarifaBoletoVendedor;
    private	Long repasseAplicacao;
    private Long valorLiquidoTransacao;
    private Integer statusPagamento;
    private	String filler;
    private Integer meioPagamento;
    private String instituicaoFinanceira;
    private	String canalEntrada;
    private Integer leitor;
    private Integer meioCaptura;
    private	String numeroLogico;
    private String nsu;
    private String cartaoBin;
    private String cartaoHolder;
    private String codAutorizacao;
    private String codCV;
    private String usoFuturo;

    public Detalhe(){}
    public Detalhe(Integer tipoRegistro,Integer estabelecimento, Date dataInicialTransacao, Date dataEvento, Calendar horaEvento, Integer tipoEvento, Integer tipoTransacao, String numeroSerieLeitor, String codTransacao, String codPedido, Long valorTotalTransacao, Long valorParcela, String pagamento, String plano, String parcela, Integer qtdParcela, Calendar dataPrevistaPagamento, Long taxaParcelamentoComprador, Long tarifaBoleto, Long valorOriginalTransacao, Long taxaParcelamentoVendedor, Long taxaIntermediacao, Long tarifaIntermediacao, Long tarifaBoletoVendedor, Long repasseAplicacao, Long valorLiquidoTransacao, Integer statusPagamento, String filler, Integer meioPagamento, String instituicaoFinanceira, String canalEntrada, Integer leitor, Integer meioCaptura, String numeroLogico, String filler2, String nsu, String cartaoBin, String cartaoHolder, String codAutorizacao, String codCV, String usoFuturo) {
        this.tipoRegistro = tipoRegistro;
        this.estabelecimento = estabelecimento;
        this.dataInicialTransacao = dataInicialTransacao;
        this.dataEvento = dataEvento;
        this.horaEvento = horaEvento;
        this.tipoEvento = tipoEvento;
        this.tipoTransacao = tipoTransacao;
        this.numeroSerieLeitor = numeroSerieLeitor;
        this.codTransacao = codTransacao;
        this.codPedido = codPedido;
        this.valorTotalTransacao = valorTotalTransacao;
        this.valorParcela = valorParcela;
        this.pagamento = pagamento;
        this.plano = plano;
        this.parcela = parcela;
        this.qtdParcela = qtdParcela;
        this.dataPrevistaPagamento = dataPrevistaPagamento;
        this.taxaParcelamentoComprador = taxaParcelamentoComprador;
        this.tarifaBoleto = tarifaBoleto;
        this.valorOriginalTransacao = valorOriginalTransacao;
        this.taxaParcelamentoVendedor = taxaParcelamentoVendedor;
        this.taxaIntermediacao = taxaIntermediacao;
        this.tarifaIntermediacao = tarifaIntermediacao;
        this.tarifaBoletoVendedor = tarifaBoletoVendedor;
        this.repasseAplicacao = repasseAplicacao;
        this.valorLiquidoTransacao = valorLiquidoTransacao;
        this.statusPagamento = statusPagamento;
        this.filler = filler;
        this.meioPagamento = meioPagamento;
        this.instituicaoFinanceira = instituicaoFinanceira;
        this.canalEntrada = canalEntrada;
        this.leitor = leitor;
        this.meioCaptura = meioCaptura;
        this.numeroLogico = numeroLogico;
        this.nsu = nsu;
        this.cartaoBin = cartaoBin;
        this.cartaoHolder = cartaoHolder;
        this.codAutorizacao = codAutorizacao;
        this.codCV = codCV;
        this.usoFuturo = usoFuturo;
    }

    @Override
    public String toString() {
        return "Detalhe{" +
                "tipoRegistro=" + tipoRegistro +
                ", estabelecimento=" + estabelecimento +
                ", dataInicialTransacao=" + dataInicialTransacao.getTime() +
//                ", dataEvento=" + dataEvento +
////                ", horaEvento=" + horaEvento +
                ", tipoEvento=" + tipoEvento +
                ", tipoTransacao=" + tipoTransacao +
                ", numeroSerieLeitor='" + numeroSerieLeitor + '\'' +
                ", codTransacao='" + codTransacao + '\'' +
                ", codPedido='" + codPedido + '\'' +
                ", valorTotalTransacao=" + valorTotalTransacao +
                ", valorParcela=" + valorParcela +
                ", pagamento='" + pagamento + '\'' +
                ", plano='" + plano + '\'' +
                ", parcela='" + parcela + '\'' +
                ", qtdParcela=" + qtdParcela +
//                ", dataPrevistaPagamento=" + dataPrevistaPagamento +
                ", taxaParcelamentoComprador=" + taxaParcelamentoComprador +
                ", tarifaBoleto=" + tarifaBoleto +
                ", valorOriginalTransacao=" + valorOriginalTransacao +
                ", taxaParcelamentoVendedor=" + taxaParcelamentoVendedor +
                ", taxaIntermediacao=" + taxaIntermediacao +
                ", tarifaIntermediacao=" + tarifaIntermediacao +
                ", tarifaBoletoVendedor=" + tarifaBoletoVendedor +
                ", repasseAplicacao=" + repasseAplicacao +
                ", valorLiquidoTransacao=" + valorLiquidoTransacao +
                ", statusPagamento=" + statusPagamento +
                ", filler='" + filler + '\'' +
                ", meioPagamento=" + meioPagamento +
                ", instituicaoFinanceira='" + instituicaoFinanceira + '\'' +
                ", canalEntrada='" + canalEntrada + '\'' +
                ", leitor=" + leitor +
                ", meioCaptura=" + meioCaptura +
                ", numeroLogico='" + numeroLogico + '\'' +
                ", nsu='" + nsu + '\'' +
                ", cartaoBin='" + cartaoBin + '\'' +
                ", cartaoHolder='" + cartaoHolder + '\'' +
                ", codAutorizacao='" + codAutorizacao + '\'' +
                ", codCV='" + codCV + '\'' +
                ", usoFuturo=" + usoFuturo +
                '}';
    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Integer getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Integer estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

//    public Calendar getDataInicialTransacao() {
//        return dataInicialTransacao;
//    }

//    public void setDataInicialTransacao(Calendar dataInicialTransacao) {
//        this.dataInicialTransacao = dataInicialTransacao;
//    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Calendar getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Calendar horaEvento) {
        this.horaEvento = horaEvento;
    }

    public Integer getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Integer tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(Integer tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getNumeroSerieLeitor() {
        return numeroSerieLeitor;
    }

    public void setNumeroSerieLeitor(String numeroSerieLeitor) {
        this.numeroSerieLeitor = numeroSerieLeitor;
    }

    public String getCodTransacao() {
        return codTransacao;
    }

    public void setCodTransacao(String codTransacao) {
        this.codTransacao = codTransacao;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Long getValorTotalTransacao() {
        return valorTotalTransacao;
    }

    public void setValorTotalTransacao(Long valorTotalTransacao) {
        this.valorTotalTransacao = valorTotalTransacao;
    }

    public Long getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Long valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Integer getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(Integer qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public Calendar getDataPrevistaPagamento() {
        return dataPrevistaPagamento;
    }

    public void setDataPrevistaPagamento(Calendar dataPrevistaPagamento) {
        this.dataPrevistaPagamento = dataPrevistaPagamento;
    }

    public Long getTaxaParcelamentoComprador() {
        return taxaParcelamentoComprador;
    }

    public void setTaxaParcelamentoComprador(Long taxaParcelamentoComprador) {
        this.taxaParcelamentoComprador = taxaParcelamentoComprador;
    }

    public Long getTarifaBoleto() {
        return tarifaBoleto;
    }

    public void setTarifaBoleto(Long tarifaBoleto) {
        this.tarifaBoleto = tarifaBoleto;
    }

    public Long getValorOriginalTransacao() {
        return valorOriginalTransacao;
    }

    public void setValorOriginalTransacao(Long valorOriginalTransacao) {
        this.valorOriginalTransacao = valorOriginalTransacao;
    }

    public Long getTaxaParcelamentoVendedor() {
        return taxaParcelamentoVendedor;
    }

    public void setTaxaParcelamentoVendedor(Long taxaParcelamentoVendedor) {
        this.taxaParcelamentoVendedor = taxaParcelamentoVendedor;
    }

    public Long getTaxaIntermediacao() {
        return taxaIntermediacao;
    }

    public void setTaxaIntermediacao(Long taxaIntermediacao) {
        this.taxaIntermediacao = taxaIntermediacao;
    }

    public Long getTarifaIntermediacao() {
        return tarifaIntermediacao;
    }

    public void setTarifaIntermediacao(Long tarifaIntermediacao) {
        this.tarifaIntermediacao = tarifaIntermediacao;
    }

    public Long getTarifaBoletoVendedor() {
        return tarifaBoletoVendedor;
    }

    public void setTarifaBoletoVendedor(Long tarifaBoletoVendedor) {
        this.tarifaBoletoVendedor = tarifaBoletoVendedor;
    }

    public Long getRepasseAplicacao() {
        return repasseAplicacao;
    }

    public void setRepasseAplicacao(Long repasseAplicacao) {
        this.repasseAplicacao = repasseAplicacao;
    }

    public Long getValorLiquidoTransacao() {
        return valorLiquidoTransacao;
    }

    public void setValorLiquidoTransacao(Long valorLiquidoTransacao) {
        this.valorLiquidoTransacao = valorLiquidoTransacao;
    }

    public Integer getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Integer statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public Integer getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(Integer meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public String getCanalEntrada() {
        return canalEntrada;
    }

    public void setCanalEntrada(String canalEntrada) {
        this.canalEntrada = canalEntrada;
    }

    public Integer getLeitor() {
        return leitor;
    }

    public void setLeitor(Integer leitor) {
        this.leitor = leitor;
    }

    public Integer getMeioCaptura() {
        return meioCaptura;
    }

    public void setMeioCaptura(Integer meioCaptura) {
        this.meioCaptura = meioCaptura;
    }

    public String getNumeroLogico() {
        return numeroLogico;
    }

    public void setNumeroLogico(String numeroLogico) {
        this.numeroLogico = numeroLogico;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCartaoBin() {
        return cartaoBin;
    }

    public void setCartaoBin(String cartaoBin) {
        this.cartaoBin = cartaoBin;
    }

    public String getCartaoHolder() {
        return cartaoHolder;
    }

    public void setCartaoHolder(String cartaoHolder) {
        this.cartaoHolder = cartaoHolder;
    }

    public String getCodAutorizacao() {
        return codAutorizacao;
    }

    public void setCodAutorizacao(String codAutorizacao) {
        this.codAutorizacao = codAutorizacao;
    }

    public String getCodCV() {
        return codCV;
    }

    public void setCodCV(String codCV) {
        this.codCV = codCV;
    }

    public String getUsoFuturo() {
        return usoFuturo;
    }

    public void setUsoFuturo(String usoFuturo) {
        this.usoFuturo = usoFuturo;
    }
}
