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
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("editar/{id}")
  public String editar(@PathVariable Integer id, Model model) {

    Map<String, Object> mapa = categoriaService.pesquisar(id);

    model.addAttribute("id", id);

    model.addAttribute("categoriaAntigaNome", mapa.get("nome").toString());

    model.addAttribute("novaCategoria", new Categoria());
    // your logic goes here
    return "categorias/editar";
  }

  @PostMapping("editar/{id}")
  public String editarPut(@PathVariable Integer id, @ModelAttribute Categoria categoria) {

    categoriaService.atualizar(id, categoria.getNome());

    // your logic goes here
    return "redirect:/categorias";
  }

}
