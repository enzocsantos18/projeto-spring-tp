package com.projeto.receitas.service;

import java.util.List;
import java.util.Map;

import com.projeto.receitas.dao.OptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
   @Autowired
   OptionDAO odao;

   public List<Map<String, Object>> exibirTags(){
      return odao.exibirTags();
   }

   public List<Map<String, Object>> exibirCategorias(){
      return odao.exibirCategorias();
   }
}
