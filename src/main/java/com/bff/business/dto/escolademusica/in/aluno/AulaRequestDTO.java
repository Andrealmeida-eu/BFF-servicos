package com.bff.business.dto.escolademusica.in.aluno;



import com.bff.business.dto.escolademusica.enums.StatusAula;
import com.bff.business.dto.escolademusica.enums.TipoAula;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaRequestDTO {

    private Long id;

    @NotNull(message = "Aluno é obrigatório")
    private Long alunoId;

    @NotNull(message = "Professor é obrigatório")
    private Long professorId;


    @Future(message = "Data deve ser no futuro")
    @NotNull(message = "Data/hora é obrigatória")
    private LocalDateTime dataHora;

    @NotNull(message = "Dia da semana da aula é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DayOfWeek diaSemanaAula;

    private TipoAula tipoAula;

    @NotNull(message = "Horário da aula é obrigatório")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horarioAula;

    @Builder.Default
    private Integer duracao = 60; // Fixo em 60 minutos

    private String observacoes;

    @Builder.Default
    private StatusAula status = StatusAula.AGENDADA;
  /*  @Future(message = "Data deve ser no futuro")
    @NotNull(message = "Data/hora é obrigatória")
    private String observacoes;
*/


    // Getters e Setters
}
