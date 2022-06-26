package com.essia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.essia.dto.DiretorioDto;
import com.essia.entity.Diretorio;
import com.essia.service.DiretorioService;

@RestController
@RequestMapping("/diretorio")
public class DiretorioController {

  @Autowired
  private DiretorioService diretorioService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Diretorio> getDirectories() {
    Optional<List<Diretorio>> list;

    list = Optional.ofNullable(diretorioService.getList());
    return (List<Diretorio>) list.get();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Diretorio getDirectory(@PathVariable Long id) {
    Diretorio result;
    try {
      result = diretorioService.getOneDir(id);
    } catch (Exception e) {
      result = null;
    }
    return result;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Diretorio postDirectory(@RequestBody DiretorioDto dto){
    Diretorio result;
    try {
      result = diretorioService.insertDir(dto);
    } catch (Exception e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }

  @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Diretorio putDirectory(@PathVariable Long id, @RequestBody DiretorioDto dto){
    Diretorio result;
    try {
      result = diretorioService.updateDir(id, dto);
    } catch (Exception e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }

  @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody String deleteDirectory(@PathVariable Long id){
    try {
      diretorioService.delDir(id);
      return "Diretório excluído com sucesso!";
    } catch (Exception e) {      
      return "O Diretório não foi excluído!";
    }
  }

}