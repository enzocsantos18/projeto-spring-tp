package com.projeto.receitas.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class OptionDAO {
   @Autowired
   DataSource dataSource;

   JdbcTemplate jdbc;

   @PostConstruct
   private void inicitialize() {
       jdbc = new JdbcTemplate(dataSource);
   }

   public List<Map<String, Object>> exibirCategorias() {
      String sql = "SELECT * from categoria";
      List<Map<String, Object>> categorias = (List<Map<String, Object>>) jdbc.queryForList(sql);
      return categorias;
  }

  public List<Map<String, Object>> exibirTags() {
      String sql = "SELECT * from tag";
      List<Map<String, Object>> tags = (List<Map<String, Object>>) jdbc.queryForList(sql);
      return tags;
   }
}
