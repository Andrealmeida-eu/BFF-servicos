package com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusProgresso;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressoAlunoResumoResponseDTO {
    private Long id;
    private Long instrumentoId;
    private String instrumentoNome;
    private StatusProgresso status;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    private BigDecimal progressoGeral;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime ultimaAtualizacao;
    private Integer totalDisciplinas;
    private Integer disciplinasConcluidas;
}
