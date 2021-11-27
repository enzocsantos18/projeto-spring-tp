package com.projeto.receitas.controller;


import com.projeto.receitas.model.Categoria;
import com.projeto.receitas.service.CategoriaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

  @Autowired
  CategoriaService categoriaService;


  @GetMapping
  public String index(Model model) {

    List<Map<String, Object>> mapaCategorias = categoriaService.exibirCategorias();
    model.addAttribute("categorias", mapaCategorias);

    model.addAttribute("novaCategoria", new Categoria());

    return "categorias/index";
  }

  @PostMapping("cadastro")
  public String cadastroPost(@ModelAttribute Categoria categoria) {

    categoriaService.adicionar(categoria);

    return "redirect:/categorias";
  }
}
