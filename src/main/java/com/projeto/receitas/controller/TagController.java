package com.projeto.receitas.controller;


import com.projeto.receitas.dao.TagsDao;
import com.projeto.receitas.service.TagService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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



    return "tags/index";
  }
}
