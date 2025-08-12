package com.bff.business.dto.loja.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoRequestDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidadeEstoque;

}
