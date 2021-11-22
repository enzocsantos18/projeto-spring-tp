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

    List<Map<String, Object>> mapaAside = receitaService.exibirReceitasTag(1);
    model.addAttribute("asides", mapaAside);


    return "index";
  }


  

}
