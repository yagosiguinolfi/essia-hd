package com.essia.service;

import java.util.List;

import com.essia.dto.ArquivoDto;
import com.essia.entity.Arquivo;

public interface ArquivoService {

  List<Arquivo> getList();

  Arquivo getOneArq(Long id);

  Arquivo insertArq(ArquivoDto dto) throws Exception;

  Arquivo updateArq(Long id, ArquivoDto dto) throws Exception;

  void delArq(Long id);
  
}
