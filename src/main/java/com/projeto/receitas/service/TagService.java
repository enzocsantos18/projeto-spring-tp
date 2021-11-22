package com.projeto.receitas.service;

import com.projeto.receitas.dao.ReceitaDAO;
import com.projeto.receitas.dao.TagsDao;
import com.projeto.receitas.dto.NovaReceitaDTO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {
   @Autowired
   TagsDao tagsDao;

   public List<Map<String, Object>> exibirTags(){
   return tagsDao.exibirTags();
   }


}
