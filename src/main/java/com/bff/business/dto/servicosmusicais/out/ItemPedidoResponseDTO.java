package com.bff.business.dto.servicosmusicais.out;

import com.bff.business.dto.servicosmusicais.in.PedidoResquestDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoResponseDTO {


    private PedidoResquestDTO pedido;
    private String servicoNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    // Getters e Setters
}
