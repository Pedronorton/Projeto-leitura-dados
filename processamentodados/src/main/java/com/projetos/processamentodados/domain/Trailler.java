package com.projetos.processamentodados.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Trailler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer tipoRegistro;
    private Integer totalRegistro;
    private String usoFuturo;

    /**
     * Construtor da classe Trailler que tem como objetivo criar o objeto trailler.
     * @param tipoRegistro
     * @param totalRegistro
     * @param usoFuturo
     */
    public Trailler(Integer tipoRegistro,Integer totalRegistro,String usoFuturo){
        this.tipoRegistro = tipoRegistro;
        this.totalRegistro = totalRegistro;
        this.usoFuturo = usoFuturo;
    }
    public Trailler(){}

    @Override
    public String toString() {
        return "Trailler{" +
                "tipoRegistro=" + tipoRegistro +
                ", totalRegistro=" + totalRegistro +
                ", usoFuturo='" + usoFuturo + '\'' +
                '}';
    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Integer getTotalRegistro() {
        return totalRegistro;
    }

    public void setTotalRegistro(Integer totalRegistro) {
        this.totalRegistro = totalRegistro;
    }

    public String getUsoFuturo() {
        return usoFuturo;
    }

    public void setUsoFuturo(String usoFuturo) {
        this.usoFuturo = usoFuturo;
    }
}
