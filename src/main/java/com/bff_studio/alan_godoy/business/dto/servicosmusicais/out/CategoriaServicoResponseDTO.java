package com.bff_studio.alan_godoy.business.dto.servicosmusicais.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaServicoResponseDTO {

    private String nome;
    private String descricao;
    private boolean ativo;


}

