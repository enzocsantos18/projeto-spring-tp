package com.projeto.receitas.dao;

import com.projeto.receitas.dto.NovaReceitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Repository
public class ReceitaDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void inicitialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> selecionarReceita(int id) {
        String sql = "SELECT r.*, c.nome as categoria " +
                "FROM receita r INNER JOIN categoria c ON r.id_categoria = c.id where r.id = ?";

        Object[] obj = new Object[1];
        obj[0] = id;
        return jdbc.queryForMap(sql, obj);
    }

    public List<Map<String, Object>> selecionarTagsReceita(int id) {
        String sql = "SELECT nome FROM tag t INNER JOIN tag_receita tc ON tc.id_tag = t.id " +
                "where tc.id_receita = ?";

        Object[] obj = new Object[1];
        obj[0] = id;

        return jdbc.queryForList(sql, obj);
    }

    public List<Map<String, Object>> categoriaCombo() {
        String sql = "select * from categoria";
        List<Map<String, Object>> receitas = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return receitas;
    }

    public List<Map<String, Object>> exibirReceitas(int id) {
        String sql = "SELECT r.*, c.nome as categoria FROM receita r INNER JOIN categoria c ON r.id_categoria = c.id where c.id = /";
        Object[] obj = new Object[1];
        obj[0] = id;

        return jdbc.queryForList(sql, obj);
    }

    public List<Map<String, Object>> exibirTodasReceitas() {
        String sql = "select distinct r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id)";
        List<Map<String, Object>> receitas = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return receitas;
     }

     public List<Map<String, Object>> exibirBusca(int idCat, int idTag) {
        if (idCat == 0) {
            String sql = "select distinct r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id) where t.id = ?";
            Object[] obj = new Object[1];
            obj[0] = idTag;

            return jdbc.queryForList(sql, obj);
        }
        if (idTag == 0) {
            String sql = "select distinct r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id) where c.id = ?";
            Object[] obj = new Object[1];
            obj[0] = idCat;

            return jdbc.queryForList(sql, obj);
        }
        String sql = "select distinct r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id) where t.id = ? and c.id = ?";
        Object[] obj = new Object[2];
        obj[0] = idTag;
        obj[1] = idCat;

        return jdbc.queryForList(sql, obj);
    }
    
    public List<Map<String, Object>> exibirReceitasTag(int id) {
        if (id == 0) {
            String sql = "select r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id)";
            List<Map<String, Object>> receitas = (List<Map<String, Object>>) jdbc.queryForList(sql);
            return receitas;
        }
        String sql = "select r.id,r.nome,r.link_img, c.nome as categoria  from tag t inner join tag_receita tc on (tc.id_tag = t.id) inner join receita r on (tc.id_receita = r.id) inner join categoria c on (r.id_categoria = c.id) where t.id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;

        return jdbc.queryForList(sql, obj);
    }

    public List<Map<String, Object>> exibirReceitasCategoria(int id) {
        if (id == 0) {
            String sql = "select distin r.id,r.nome,r.link_img, c.nome as categoria  from receita r inner join categoria c on (r.id_categoria = c.id)";
            List<Map<String, Object>> receitas = (List<Map<String, Object>>) jdbc.queryForList(sql);
            return receitas;
        }
        String sql = "select r.id,r.nome,r.link_img, c.nome as categoria  from receita r inner join categoria c on (r.id_categoria = c.id) where c.id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;

        return jdbc.queryForList(sql, obj);
    }

    public void deletarReceita(int id){
      Object[] obj = new Object[1];
      obj[0] = id;
      String sqlTagReceita = "delete from Tag_Receita where id_receita = ?";
      jdbc.update(sqlTagReceita, obj);

      String sqlReceita = "delete from receita where id = ?";
      jdbc.update(sqlReceita, obj);
    }

    @Transactional
    public void adicionar(NovaReceitaDTO novaReceita) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO " +
                            "Receita(NOME, LINK_IMG, TEMPO, QT_PORCAO, ID_CATEGORIA, INGREDIENTES, MODO_PREPARO) " +
                            "VALUES (?,?,?,?,?,?,?)", new String[]{"id"});
            ps.setString(1, novaReceita.getNome());
            ps.setString(2, novaReceita.getLinkImg());
            ps.setInt(3, novaReceita.getTempo());
            ps.setInt(4, novaReceita.getPorcao());
            ps.setInt(5, novaReceita.getIdCategoria());
            ps.setString(6, novaReceita.getIngredientes());
            ps.setString(7, novaReceita.getModoPreparo());

            return ps;
        }, keyHolder);

        int id = (int) keyHolder.getKey();


        for (Integer tag : novaReceita.getIdTags()) {
            jdbc.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement("INSERT INTO Tag_Receita(ID_RECEITA, ID_TAG) VALUES (?,?)");
                ps.setInt(1, id);
                ps.setInt(2, tag);


                return ps;
            });
        }


    }
}
