package com.projeto.receitas.service;

import java.util.List;
import java.util.Map;

import com.projeto.receitas.dao.ReceitaDAO;
import com.projeto.receitas.dto.NovaReceitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceitaService {
   @Autowired
   ReceitaDAO rdao;

   public Map<String, Object> selecionarReceita(int id){
      return rdao.selecionarReceita(id);
   }

   public List<Map<String, Object>> selecionarTagsReceita(int id){
      return rdao.selecionarTagsReceita(id);
  }

   public List<Map<String, Object>> exibirReceitas(int id){
   return rdao.exibirReceitas(id);
   }

   public List<Map<String, Object>> exibirBusca(int idCat, int idTag){
      return rdao.exibirBusca(idCat, idTag);
   }

   public List<Map<String, Object>> exibirTodasReceitas(){
      return rdao.exibirTodasReceitas();
      }

   public List<Map<String, Object>> categoriaCombo(){
      return rdao.categoriaCombo();
      }

   public List<Map<String, Object>> exibirReceitasTag(int id){
      return rdao.exibirReceitasTag(id);
   }

   public List<Map<String, Object>> exibirReceitasCategoria(int id){
      return rdao.exibirReceitasCategoria(id);
   }

   public void deletarReceita(int id){
      rdao.deletarReceita(id);
   }

   @Transactional
   public void adicionar(NovaReceitaDTO novaReceita) {
      rdao.adicionar(novaReceita);
   }
}
