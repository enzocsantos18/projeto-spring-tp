package com.projeto.receitas.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NovaReceitaDTO {
    private Integer idCategoria;
    private Integer porcao;
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private String linkImg;
    private Integer tempo;
    private List<Integer> idTags = new ArrayList<>();
}
