package com.bff.business.dto.escolademusica.out.receita;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceitaResponseDTO {

    private double receitaTotal;
    private double custoTotal;
    private double lucroTotal;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;
    private int TotalMensalidades;
    private int mensalidadesPagas;
    private int mensalidadesPendentes;
}
