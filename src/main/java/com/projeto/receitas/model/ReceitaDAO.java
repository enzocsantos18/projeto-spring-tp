package com.projeto.receitas.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReceitaDAO {
   @Autowired
   DataSource dataSource;

   JdbcTemplate jdbc;

   @PostConstruct
   private void inicitialize() {
      jdbc = new JdbcTemplate(dataSource);
   }

   public Map<String, Object> selecionarReceita(int id){
      String sql = "SELECT r.*, c.nome as categoria "+
      "FROM receita r INNER JOIN categoria c ON r.id_categoria = c.id where r.id = ?";

      Object[] obj = new Object[1];
      obj[0] = id;
      return jdbc.queryForMap(sql, obj);
   }

   public List<Map<String, Object>> selecionarTagsReceita(int id){
      String sql = "SELECT nome FROM tag t INNER JOIN tag_receita tc ON tc.id_tag = t.id "+
      "where tc.id_receita = ?";

      Object[] obj = new Object[1];
      obj[0] = id;

      return jdbc.queryForList(sql, obj);
   }
}
