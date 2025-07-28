package com.bff_studio.alan_godoy.business.dto.servicosmusicais.in;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.enums.StatusPedido;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoResquestDTO {

    private Long id;
    private Long clienteId;
    private String clienteNome;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private StatusPedido status;
    private List<ItemPedidoResquestDTO> itens;

}
