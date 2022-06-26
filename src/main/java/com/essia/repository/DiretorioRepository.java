package com.essia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essia.entity.Diretorio;

public interface DiretorioRepository extends JpaRepository<Diretorio, Long> { 
  
}
