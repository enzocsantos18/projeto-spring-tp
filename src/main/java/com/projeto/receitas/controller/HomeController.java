package com.projeto.receitas.controller;


import com.projeto.receitas.service.OptionService;
import com.projeto.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class HomeController {

  @Autowired
  private ReceitaService receitaService;

  @Autowired
  private OptionService optionService;

  @GetMapping
  public String index(Model model) {

    List<Map<String, Object>> mapaComboCat = receitaService.categoriaCombo();
    model.addAttribute("comboCats", mapaComboCat);

    List<Map<String, Object>> mapaComboTag = optionService.exibirTags();
    model.addAttribute("comboTags", mapaComboTag);

    List<Map<String, Object>> mapaReceitas = receitaService.exibirTodasReceitas();
    model.addAttribute("receitas", mapaReceitas);


    return "index";
  }

  @GetMapping("/busca/{idCat}/{idTag}")
  public String index(@PathVariable("idCat") int idCat,@PathVariable("idTag") int idTag, Model model) {

    List<Map<String, Object>> mapaComboCat = receitaService.categoriaCombo();
    model.addAttribute("comboCats", mapaComboCat);

    List<Map<String, Object>> mapaComboTag = optionService.exibirTags();
    model.addAttribute("comboTags", mapaComboTag);

    //List<Map<String, Object>> mapaCombo = receitaService.categoriaCombo();
    //model.addAttribute("combo", mapaCombo);

    List<Map<String, Object>> mapareceitas = receitaService.exibirBusca(idCat,idTag);
    model.addAttribute("receitas", mapareceitas);

    //List<Map<String, Object>> mapareceitas = receitaService.exibirReceitasCategoria(idCat);
    //model.addAttribute("receitas", mapareceitas);


    //List<Map<String, Object>> mapareceitasTag = receitaService.exibirReceitasTag(idTag);
    //model.addAttribute("receitasTag", mapareceitasTag);

    return "index";
  }

  @PostMapping("/busca")
    public String buscarPost(@RequestParam(value = "tags") Integer tags, @RequestParam(value = "categoria") Integer categoria, Model model) {
      if (tags > 0) {
        if (categoria > 0) {
          return "redirect:/busca/" + categoria + "/" + tags;
        }
        else{
          return "redirect:/busca/0/" + tags;

        }
      }
      else{
        if (categoria > 0) {
          List<Map<String, Object>> mapareceitasCategoria = receitaService.exibirReceitasCategoria(categoria);
          model.addAttribute("receitasCat", mapareceitasCategoria);
          return "redirect:/busca/" + categoria + "/0";
        }
      }
      return "redirect:/";
    }




  

}
