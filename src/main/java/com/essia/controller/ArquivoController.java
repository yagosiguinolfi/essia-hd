package com.essia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.essia.dto.ArquivoDto;
import com.essia.entity.Arquivo;
import com.essia.service.ArquivoService;

@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

  @Autowired
  private ArquivoService arquivoService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Arquivo> getArchives() {
    Optional<List<Arquivo>> list;

    list = Optional.ofNullable(arquivoService.getList());
    return (List<Arquivo>) list.get();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Arquivo getArchive(@PathVariable Long id) {
    Arquivo result;
    try {
      result = arquivoService.getOneArq(id);
    } catch (Exception e) {
      result = null;
    }
    return result;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Arquivo postArchive(@RequestBody ArquivoDto dto){
    Arquivo result;
    try {
      result = arquivoService.insertArq(dto);
    } catch (Exception e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }

  @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Arquivo putArchive(@PathVariable Long id, @RequestBody ArquivoDto dto){
    Arquivo result;
    try {
      result = arquivoService.updateArq(id, dto);
    } catch (Exception e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }

  @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody String deleteArchive(@PathVariable Long id){
    try {
      arquivoService.delArq(id);
      return "Arqetório excluído com sucesso!";
    } catch (Exception e) {      
      return "O Arqetório não foi excluído!";
    }
  }

}