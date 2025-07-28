package com.bff_studio.alan_godoy.business.dto.loja.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceitaResponseDTO {
    private Double receitaTotal;
    private Double custoTotal;
    private Double lucroTotal;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    // Getters e Setters
}
