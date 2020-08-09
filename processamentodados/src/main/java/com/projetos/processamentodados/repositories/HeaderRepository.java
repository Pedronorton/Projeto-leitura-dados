package com.projetos.processamentodados.repositories;

import com.projetos.processamentodados.domain.Header;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderRepository extends JpaRepository<Header, Integer> {
    
}
