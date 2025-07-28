package com.bff_studio.alan_godoy.business.dto.servicosmusicais.out;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoResponseDTO {


    private String clienteNome;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPedido;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataEntrega;
    private StatusPedido status;
    private List<ItemPedidoResponseDTO> itens;

}
