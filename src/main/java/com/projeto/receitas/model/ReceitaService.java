package com.projeto.receitas.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   
}
