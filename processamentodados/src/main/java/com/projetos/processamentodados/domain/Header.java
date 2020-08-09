package com.projetos.processamentodados.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name="HEADER")
public class Header implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoRegistro;
    private Long estabelecimento;
    private Date dataProcessamento;
    private Calendar periodoInicial;
    private Calendar periodoFinal;
    private Integer sequencia;
    private String empresaAdquirinte;
    private Integer tipoExtrato;
    private String filler;
    private String versaoLayout;
    private String versaoRelease;
    private String usoFuturo;

    @Override
    public String toString() {
        return "Header{" +
                "tipoRegistro=" + tipoRegistro +
                ", estabelecimento=" + estabelecimento +
                ", dataProcessamento=" + dataProcessamento +
                ", periodoInicial=" + periodoInicial +
                ", periodoFinal=" + periodoFinal +
                ", sequencia=" + sequencia +
                ", empresaAdquirinte='" + empresaAdquirinte + '\'' +
                ", tipoExtrato=" + tipoExtrato +
                ", filler='" + filler + '\'' +
                ", versaoLayout='" + versaoLayout + '\'' +
                ", versaoRelease='" + versaoRelease + '\'' +
                ", usoFuturo='" + usoFuturo + '\'' +
                '}';
    }

    public Header(Integer tipoRegistro, Long estabelecimento, Date dataProcessamento, Calendar periodoInicial, Calendar  periodoFinal, Integer sequencia, String empresaAdquirinte,
                  Integer tipoExtrato, String filler, String versaoLayout, String versaoRelease){

        this.tipoRegistro = tipoRegistro;
        this.estabelecimento = estabelecimento;
        this.dataProcessamento = dataProcessamento;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.sequencia = sequencia;
        this.empresaAdquirinte = empresaAdquirinte;
        this.tipoExtrato = tipoExtrato;
        this.filler = filler;
        this.versaoLayout = versaoLayout;
        this.versaoRelease = versaoRelease;
        this.usoFuturo = "";
    }

    public Header(){}

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Long getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Long estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public Calendar getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Calendar periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Calendar getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Calendar periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public String getEmpresaAdquirinte() {
        return empresaAdquirinte;
    }

    public void setEmpresaAdquirinte(String empresaAdquirinte) {
        this.empresaAdquirinte = empresaAdquirinte;
    }

    public Integer getTipoExtrato() {
        return tipoExtrato;
    }

    public void setTipoExtrato(Integer tipoExtrato) {
        this.tipoExtrato = tipoExtrato;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public void setVersaoLayout(String versaoLayout) {
        this.versaoLayout = versaoLayout;
    }

    public String getVersaoRelease() {
        return versaoRelease;
    }

    public void setVersaoRelease(String versaoRelease) {
        this.versaoRelease = versaoRelease;
    }

    public String getUsoFuturo() {
        return usoFuturo;
    }

    public void setUsoFuturo(String usoFuturo) {
        this.usoFuturo = usoFuturo;
    }
}
