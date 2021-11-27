package com.projeto.receitas.dao;

import com.projeto.receitas.model.Categoria;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriasDao {

  @Autowired
  DataSource dataSource;

  JdbcTemplate jdbc;

  @PostConstruct
  private void inicitialize() {
    jdbc = new JdbcTemplate(dataSource);
  }


  public List<Map<String, Object>> exibirCategorias() {
    String sql = "SELECT * from categoria";
    return (List<Map<String, Object>>) jdbc.queryForList(sql);
  }

  public void adicionar(Categoria categoria) {
    jdbc.update("INSERT INTO categoria(nome) values ('" + categoria.getNome() + "');");
  }
}

