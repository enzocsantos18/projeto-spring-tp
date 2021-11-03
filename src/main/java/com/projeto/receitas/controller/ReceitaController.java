package com.projeto.receitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

  @GetMapping
  public String index() {
    return "receitas/index";
  }

  @GetMapping("cadastro")
  public String cadastro() {
    return "receitas/cadastro";
  }

  

}
