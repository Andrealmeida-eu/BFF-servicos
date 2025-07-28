package com.bff_studio.alan_godoy.business.dto.escolademusica.out.conteudo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisciplinaResponseDTO {


private Long id;
    private String nome;
    private String descricao;
    private Integer ordem;
    private List<TopicoResponseDTO> topicos;

    // Getters e Setters

}
