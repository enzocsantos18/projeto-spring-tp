package com.projeto.receitas.model;

public class Receita {
   private int id, id_categoria, porcao;
   private String nome, ingredientes, modo_preparo, link_img, tempo, categoria;

   public Receita(){

   }

   public Receita(int id, int id_categoria, int porcao, String nome, String ingredientes, String modo_preparo, String link_img, String tempo, String categoria){
      this.id = id;
      this.id_categoria = id_categoria;
      this.porcao = porcao;
      this.nome = nome;
      this.ingredientes = ingredientes;
      this.modo_preparo = modo_preparo;
      this.link_img = link_img;
      this.tempo = tempo;
      this.categoria = categoria;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getIdCategoria() {
      return id_categoria;
   }

   public void setIdCategoria(int idCategoria) {
      this.id_categoria = idCategoria;
   }

   public int getPorcao() {
      return porcao;
   }

   public void setPorcao(int porcao){
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

   public void setIngredientes(String ingredientes){
      this.ingredientes = ingredientes;
   }
   public String getModoPreparo() {
      return modo_preparo;
   }

   public void setModoPreparo(String modoPreparo){
      this.modo_preparo = modoPreparo;
   }

   public String getTempo() {
      return tempo;
   }

   public void setTempo(String tempo){
      this.tempo = tempo;
   }

   public String getLinkImg() {
      return link_img;
   }

   public void setLinkImg(String linkImg){
      this.link_img = linkImg;
   }

   public String getCategoria() {
      return categoria;
   }

   public void setCategoria(String categoria){
      this.categoria = categoria;
   }
}