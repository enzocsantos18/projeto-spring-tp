package com.projeto.receitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

  @GetMapping
  public String index() {
    return "index";
  }

  @GetMapping("visualizacao")
  public String visualizacao() {
    return "visualizacao";
  }
}
