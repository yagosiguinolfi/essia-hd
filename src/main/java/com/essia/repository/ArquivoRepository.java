package com.essia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essia.entity.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> { 
  
}
