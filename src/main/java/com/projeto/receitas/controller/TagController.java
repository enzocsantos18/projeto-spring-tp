package com.projeto.receitas.controller;


import com.projeto.receitas.dao.TagsDao;
import com.projeto.receitas.dto.NovaReceitaDTO;
import com.projeto.receitas.model.Tag;
import com.projeto.receitas.service.TagService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
