package com.essia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essia.dto.ArquivoDto;
import com.essia.entity.Arquivo;
import com.essia.repository.ArquivoRepository;
import com.essia.service.ArquivoService;

@Service
public class ArquivoServiceImpl implements ArquivoService {

  @Autowired
  ArquivoRepository ArquivoRepository;

  public List<Arquivo> getList(){
    return ArquivoRepository.findAll();
  }

  @Override
  public Arquivo getOneArq(Long id) {
    return ArquivoRepository.findById(id).get();
  }

  @Override
  public Arquivo insertArq(ArquivoDto dto) throws Exception {
    Arquivo Arq = new Arquivo();
    try{
      Arq.setNome(dto.getNome());
      Arq.setIdDiretorio(dto.getIdDiretorio());
    Arq = ArquivoRepository.save(Arq);
    }catch(Exception e){
      throw new Exception(e);
    }
    return Arq;
  }

  @Override
  public Arquivo updateArq(Long id, ArquivoDto dto) throws Exception {
    Arquivo Arq;
    Arq = ArquivoRepository.findById(id).get();
      try {
        Arq.setNome(dto.getNome());
        Arq.setIdDiretorio(dto.getIdDiretorio());
        Arq = ArquivoRepository.save(Arq);
      } catch (Exception e) {      
        throw new Exception(e);
      }
    return Arq;
  }

  @Override
  public void delArq(Long id) {
    ArquivoRepository.deleteById(id);    
  }

}
