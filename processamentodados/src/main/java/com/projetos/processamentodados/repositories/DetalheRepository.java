package com.projetos.processamentodados.repositories;

import com.projetos.processamentodados.domain.Detalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface DetalheRepository extends JpaRepository<Detalhe,Integer> {

    List<Detalhe> findByinstituicaoFinanceira(String instituicaoFinanceira);

    @Transactional(readOnly = true)
    @Query("select obj from Detalhe obj where obj.qtdParcela = :tipoPagamento")
    List<Detalhe> findByVista(Integer tipoPagamento);

    @Transactional(readOnly = true)
    @Query("select obj from Detalhe obj where obj.qtdParcela != 1 and obj.qtdParcela != 0")
    List<Detalhe> findByPrazo();

    @Query("select obj from Detalhe obj where obj.dataEvento BETWEEN :dataInicial AND :dataFinal ")
    List<Detalhe> findByDate(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
}
