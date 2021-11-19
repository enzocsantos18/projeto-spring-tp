package com.projeto.receitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

  @GetMapping("/{id}")
  public String index(@PathVariable("id") int id, Model model) {
    model.addAttribute("nome", "TORTA <br> HOLANDESA");
    return "receitas/index";
  }

  @GetMapping("cadastro")
  public String cadastro() {
    return "receitas/cadastro";
  }

  

}
