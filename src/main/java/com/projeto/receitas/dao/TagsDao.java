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
    String sql = "SELECT * from tag order by id";
    return (List<Map<String, Object>>) jdbc.queryForList(sql);
  }

  public void adicionar(Tag tag) {
    String sql = "INSERT INTO tag(nome) values (?) ";

    Object[] obj = new Object[1];
    obj[0] = tag.getNome();

    jdbc.update(sql, obj);
  }

  public Map<String, Object> pesquisar(Integer id) {

    String sql = "SELECT * from tag where id = ?";

    Object[] obj = new Object[1];
    obj[0] = id;
    return jdbc.queryForMap(sql, obj);

  }

  public void atualizar(Integer id, String nome) {

    String sql = "UPDATE tag SET nome = ? where id = ? ";

    Object[] obj = new Object[2];
    obj[0] = nome;
    obj[1] = id;
    jdbc.update(sql, obj);
  }
}

