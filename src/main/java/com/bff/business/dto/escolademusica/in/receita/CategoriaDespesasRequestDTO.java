package com.bff.business.dto.escolademusica.in.receita;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDespesasRequestDTO {

    private Long id;
    private String nome;
    private String descricao;

}
