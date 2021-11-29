package com.projeto.receitas.controller;

import com.projeto.receitas.dto.NovaReceitaDTO;
import com.projeto.receitas.service.ReceitaService;
import com.projeto.receitas.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/receitas")
@ComponentScan("model")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;
    @Autowired
    private OptionService optionService;

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model) {
        Map<String, Object> mapa = receitaService.selecionarReceita(id);
        model.addAttribute("id", id);
        model.addAttribute("nome", mapa.get("nome").toString().toUpperCase());
        model.addAttribute("porcao", mapa.get("qt_porcao"));
        model.addAttribute("ingredientes", mapa.get("ingredientes").toString().split(";"));
        model.addAttribute("modo_preparo", mapa.get("modo_preparo").toString().split(";"));
        model.addAttribute("tempo", mapa.get("tempo"));
        model.addAttribute("link_img", mapa.get("link_img"));
        model.addAttribute("categoria", mapa.get("categoria"));

        List<Map<String, Object>> mapaTag = receitaService.selecionarTagsReceita(id);
        List<String> tags = new ArrayList<>();
        for (Map<String, Object> tag : mapaTag) {
            tags.add(tag.get("nome").toString());
        }
        model.addAttribute("tags", tags);
        return "receitas/index";
    }

    @GetMapping("cadastro")
    public String cadastro(Model model) {
         model.addAttribute("novaReceita", new NovaReceitaDTO());
         
         List<Map<String, Object>> tags = optionService.exibirTags();
         model.addAttribute("tags", tags);

         List<Map<String, Object>> categorias = optionService.exibirCategorias();
         model.addAttribute("categorias", categorias);
         return "receitas/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastroPost(@ModelAttribute NovaReceitaDTO novaReceita, @RequestParam("tags") List<Integer> tags) {
        for (Integer tag: tags) {
            novaReceita.getIdTags().add(tag);
        }

        receitaService.adicionar(novaReceita);

        return "redirect:/";
    }

    @PostMapping("apagar/{id}")
    public String apagarReceita(@PathVariable int id) {
        receitaService.deletarReceita(id);

        return "redirect:/";
    }


}
