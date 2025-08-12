package com.bff.business.dto.loja.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponseDTO {

    private String nome;
    private String descricao;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidadeEstoque;

}
