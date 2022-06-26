package com.essia.service;

import java.util.List;

import com.essia.dto.DiretorioDto;
import com.essia.entity.Diretorio;

public interface DiretorioService {

  List<Diretorio> getList();

  Diretorio getOneDir(Long id);

  Diretorio insertDir(DiretorioDto dto) throws Exception;

  Diretorio updateDir(Long id, DiretorioDto dto) throws Exception;

  void delDir(Long id);
  
}
