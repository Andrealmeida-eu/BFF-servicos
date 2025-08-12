package com.bff.business.dto.loja.in;

import lombok.*;

import java.time.YearMonth;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendasMensalRequestDTO {
    private YearMonth mesAno;
    private long quantidadeVendas;

    // Construtor, getters e setters
}
