package com.projeto.receitas.controller;


import com.projeto.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class HomeController {

  @Autowired
  private ReceitaService receitaService;

  @GetMapping
  public String index(Model model) {
    List<Map<String, Object>> mapareceitas = receitaService.exibirReceitas();

    model.addAttribute("receitas", mapareceitas);
    //List<String> receitas = new ArrayList<>();
    //List<String> nomes = new ArrayList<>();
    //List<Integer> id = new ArrayList<>();
    //    for (Map<String, Object> receita : //mapareceitas) {
//
    //      nomes.add(receita.get("nome").toString().//toUpperCase());
    //      id.add(Integer.parseInt(receita.get("id").//toString()));
    //      //receitas.add(receita.get("id"));
    //      //receitas.add(receita.get("categoria").//toString());
    //      model.addAttribute("link_img", receita.get//("link_img"));
    //      model.addAttribute("categoria", receita.get//("categoria"));
    //      //receitas.add(receita.get("link_img").//toString());
    //    }
    //    model.addAttribute("receitas", receitas);
    //    model.addAttribute("id", id);
    //    model.addAttribute("nome", nomes);
    return "index";
  }


  

}
