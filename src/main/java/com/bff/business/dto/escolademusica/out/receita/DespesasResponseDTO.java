package com.bff.business.dto.escolademusica.out.receita;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DespesasResponseDTO {

    private String descricao;
    private BigDecimal valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    private String categoriaNome;
}
