package com.essia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essia.dto.DiretorioDto;
import com.essia.entity.Diretorio;
import com.essia.repository.DiretorioRepository;
import com.essia.service.DiretorioService;

@Service
public class DiretorioServiceImpl implements DiretorioService {

  @Autowired
  DiretorioRepository diretorioRepository;

  public List<Diretorio> getList(){
    return diretorioRepository.findAll();
  }

  @Override
  public Diretorio getOneDir(Long id) {
    return diretorioRepository.findById(id).get();
  }

  @Override
  public Diretorio insertDir(DiretorioDto dto) throws Exception {
    Diretorio dir = new Diretorio();
    try{
      dir.setNome(dto.getNome());
      dir.setIdPai(dto.getIdPai());
    dir = diretorioRepository.save(dir);
    }catch(Exception e){
      throw new Exception(e);
    }
    return dir;
  }

  @Override
  public Diretorio updateDir(Long id, DiretorioDto dto) throws Exception {
    Diretorio dir;
    dir = diretorioRepository.findById(id).get();
      try {
        dir.setNome(dto.getNome());
        dir.setIdPai(dto.getIdPai());
        dir = diretorioRepository.save(dir);
      } catch (Exception e) {      
        throw new Exception(e);
      }
    return dir;
  }

  @Override
  public void delDir(Long id) {
    diretorioRepository.deleteById(id);    
  }

}
