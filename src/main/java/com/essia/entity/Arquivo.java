package com.essia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivo")
public class Arquivo{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(name = "id_diretorio")
  private int idDiretorio;
  
  public Arquivo() {
  }

  public Arquivo(String nome, int idDiretorio) {
    this.nome = nome;
    this.idDiretorio = idDiretorio;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public int getIdDiretorio() {
    return idDiretorio;
  }
  public void setIdDiretorio(int idDiretorio) {
    this.idDiretorio = idDiretorio;
  }

  
}