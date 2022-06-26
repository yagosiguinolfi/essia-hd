package com.essia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diretorio")
public class Diretorio{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String nome;
  @Column(name="id_pai")
  private Long idPai;
  
  public Diretorio() {
  }

  public Diretorio(String nome, Long idPai) {
    this.nome = nome;
    this.idPai = idPai;
  }

  public Diretorio(Long id, String nome, Long idPai) {
    this.id = id;
    this.nome = nome;
    this.idPai = idPai;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Long getIdPai() {
    return idPai;
  }
  public void setIdPai(Long idPai) {
    this.idPai = idPai;
  }

}