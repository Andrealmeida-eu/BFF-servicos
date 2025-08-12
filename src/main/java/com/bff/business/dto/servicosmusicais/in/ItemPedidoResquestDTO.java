package com.bff.business.dto.servicosmusicais.in;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoResquestDTO {

    private Long id;
    private Long pedidoId;
    private Long servicoId;
    private PedidoResquestDTO pedido;
    private String servicoNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    // Getters e Setters
}
