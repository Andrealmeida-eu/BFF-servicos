package com.bff.business.dto.escolademusica.out.progresso;


import com.bff.business.dto.escolademusica.enums.StatusTopico;
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
public class ProgressoTopicoResponseDTO {
    private Long id;
    private Long topicoId;
    private String topicoNome;
    private StatusTopico status;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao;
    private boolean concluido;
    private int ordem;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Builder.Default
    private LocalDateTime ultimaAtualizacao = LocalDateTime.now();

    @Builder.Default
    private BigDecimal progresso = BigDecimal.ZERO;
}
