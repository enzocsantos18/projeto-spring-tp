package com.projeto.receitas.controller;


import com.projeto.receitas.model.Tag;
import com.projeto.receitas.service.TagService;
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
@RequestMapping("tags")
public class TagController {

  @Autowired
  TagService tagService;


  @GetMapping
  public String index(Model model) {

    List<Map<String, Object>> mapaTags = tagService.exibirTags();
    model.addAttribute("tags", mapaTags);

    model.addAttribute("novaTag", new Tag());

    return "tags/index";
  }

  @PostMapping("cadastro")
  public String cadastroPost(@ModelAttribute Tag tag) {

    tagService.adicionar(tag);

    return "redirect:/tags";
  }

  @GetMapping("editar/{id}")
  public String editar(@PathVariable Integer id, Model model) {

    Map<String, Object> mapa = tagService.pesquisar(id);

    model.addAttribute("id", id);

    model.addAttribute("tagAntigaNome", mapa.get("nome").toString());

    model.addAttribute("novaTag", new Tag());
    // your logic goes here
    return "tags/editar";
  }

  @PostMapping("editar/{id}")
  public String editarPut(@PathVariable Integer id, @ModelAttribute Tag tag) {

    tagService.atualizar(id, tag.getNome());

    // your logic goes here
    return "redirect:/tags";
  }
}
