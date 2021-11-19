package com.projeto.receitas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.projeto.receitas.model.Receita;
import com.projeto.receitas.model.ReceitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receitas")
@ComponentScan("model")
public class ReceitaController {

   @Autowired
   private ApplicationContext context;

  @GetMapping("/{id}")
  public String index(@PathVariable("id") int id, Model model) {
   //  model.addAttribute("receita", new Receita());
   //  model.addAttribute("nome", "TORTA <br> HOLANDESA");


    ReceitaService rs = context.getBean(ReceitaService.class);
    Map<String, Object> mapa = rs.selecionarReceita(id);
    model.addAttribute("nome", mapa.get("nome").toString().toUpperCase());
    model.addAttribute("porcao", mapa.get("qt_porcao"));
    model.addAttribute("ingredientes", mapa.get("ingredientes").toString().split(";"));
    model.addAttribute("modo_preparo", mapa.get("modo_preparo").toString().split(";"));
    model.addAttribute("tempo", mapa.get("tempo"));
    model.addAttribute("link_img", mapa.get("link_img"));
    model.addAttribute("categoria", mapa.get("categoria"));

    List<Map<String, Object>> mapaTag = rs.selecionarTagsReceita(id);
    List<String> tags = new ArrayList<>();
    for(Map<String, Object> tag : mapaTag) {
      tags.add(tag.get("nome").toString());
    }
    model.addAttribute("tags", tags);
    return "receitas/index";
  }

  @GetMapping("cadastro")
  public String cadastro() {
    return "receitas/cadastro";
  }

  

}
