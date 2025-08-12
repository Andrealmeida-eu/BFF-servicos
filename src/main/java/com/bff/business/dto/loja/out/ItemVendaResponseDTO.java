package com.bff.business.dto.loja.out;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemVendaResponseDTO {

    private String produtoNome;
    private Integer quantidade;
    private Double precoUnitario;
    private Double subtotal;

    // Getters e Setters
}
