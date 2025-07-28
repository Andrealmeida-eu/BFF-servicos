package com.bff_studio.alan_godoy.business.dto.loja.Specification;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoFiltro {

    private String nome;
    private Double precoMin;
    private Double precoMax;
    private Boolean comEstoque;

}
