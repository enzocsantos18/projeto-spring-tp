package com.projeto.receitas.service;

import com.projeto.receitas.dao.CategoriasDao;
import com.projeto.receitas.model.Categoria;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

  @Autowired
  CategoriasDao categoriasDao;

  public List<Map<String, Object>> exibirCategorias() {
    return categoriasDao.exibirCategorias();
  }

  @Transactional
  public void adicionar(Categoria categoria) {
    categoriasDao.adicionar(categoria);
  }

  public Map<String, Object> pesquisar(Integer id) {
    return categoriasDao.pesquisar(id);
  }

  @Transactional
  public void atualizar(Integer id, String nome) {
    categoriasDao.atualizar(id, nome);
  }

  @Transactional
  public boolean deletar(Integer id) {
    return categoriasDao.deletar(id);
  }
}
