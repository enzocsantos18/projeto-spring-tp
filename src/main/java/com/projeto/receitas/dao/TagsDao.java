package com.projeto.receitas.dao;

import com.projeto.receitas.model.Tag;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TagsDao {

  @Autowired
  DataSource dataSource;

  JdbcTemplate jdbc;

  @PostConstruct
  private void inicitialize() {
    jdbc = new JdbcTemplate(dataSource);
  }


  public List<Map<String, Object>> exibirTags() {
    String sql = "SELECT * from tag";
    return (List<Map<String, Object>>) jdbc.queryForList(sql);
  }

  public void adicionar(Tag tag) {
    jdbc.update("INSERT INTO Tag(nome) values ('" + tag.getNome()+ "');");
  }
}

