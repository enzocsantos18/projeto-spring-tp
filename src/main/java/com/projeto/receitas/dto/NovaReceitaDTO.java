package com.projeto.receitas.dto;

import java.util.ArrayList;
import java.util.List;


public class NovaReceitaDTO {

  private Integer idCategoria;
  private Integer porcao;
  private String nome;
  private String ingredientes;
  private String modoPreparo;
  private String linkImg;
  private Integer tempo;
  private List<Integer> idTags = new ArrayList<>();

  public NovaReceitaDTO() {
  }


  public NovaReceitaDTO(Integer idCategoria, Integer porcao, String nome,
      String ingredientes, String modoPreparo, String linkImg, Integer tempo,
      List<Integer> idTags) {
    this.idCategoria = idCategoria;
    this.porcao = porcao;
    this.nome = nome;
    this.ingredientes = ingredientes;
    this.modoPreparo = modoPreparo;
    this.linkImg = linkImg;
    this.tempo = tempo;
    this.idTags = idTags;
  }


  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public Integer getPorcao() {
    return porcao;
  }

  public void setPorcao(Integer porcao) {
    this.porcao = porcao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(String ingredientes) {
    this.ingredientes = ingredientes;
  }

  public String getModoPreparo() {
    return modoPreparo;
  }

  public void setModoPreparo(String modoPreparo) {
    this.modoPreparo = modoPreparo;
  }

  public String getLinkImg() {
    return linkImg;
  }

  public void setLinkImg(String linkImg) {
    this.linkImg = linkImg;
  }

  public Integer getTempo() {
    return tempo;
  }

  public void setTempo(Integer tempo) {
    this.tempo = tempo;
  }

  public List<Integer> getIdTags() {
    return idTags;
  }

  public void setIdTags(List<Integer> idTags) {
    this.idTags = idTags;
  }

  @Override
  public String toString() {
    return "NovaReceitaDTO{" +
        "idCategoria=" + idCategoria +
        ", porcao=" + porcao +
        ", nome='" + nome + '\'' +
        ", ingredientes='" + ingredientes + '\'' +
        ", modoPreparo='" + modoPreparo + '\'' +
        ", linkImg='" + linkImg + '\'' +
        ", tempo=" + tempo +
        ", idTags=" + idTags +
        '}';
  }
}
