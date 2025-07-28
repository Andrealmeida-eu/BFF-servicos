package com.bff_studio.alan_godoy.business.dto.loja.out;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendaResponseDTO {


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private Double valorTotal;
    private List<ItemVendaResponseDTO> itens;

    // Getters e Setters
}

