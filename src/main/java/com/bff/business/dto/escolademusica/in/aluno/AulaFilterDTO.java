package com.bff.business.dto.escolademusica.in.aluno;


import com.bff.business.dto.escolademusica.enums.StatusAula;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaFilterDTO {

    private Long alunoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private DayOfWeek diaSemana;
    private StatusAula status;

    // getters e setters
}
