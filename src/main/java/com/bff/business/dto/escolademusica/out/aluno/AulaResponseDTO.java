package com.bff.business.dto.escolademusica.out.aluno;



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
public class AulaResponseDTO {

    private Long id;

    @Future(message = "Data deve ser no futuro")
    @NotNull(message = "Data/hora é obrigatória")

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    private String alunoNome;

    private TipoAula tipoAula;

    private String professorNome;

    private String InstrumentoNome;

    @NotNull(message = "Dia da semana da aula é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DayOfWeek diaSemanaAula;

    @NotNull(message = "Horário da aula é obrigatório")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horarioAula;

    @Builder.Default
    private Integer duracao = 60; // Fixo em 60 minutos

    private String observacoes;

    @Builder.Default
    private StatusAula status = StatusAula.AGENDADA;

}
