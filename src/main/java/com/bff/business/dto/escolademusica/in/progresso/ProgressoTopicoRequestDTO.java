package com.bff.business.dto.escolademusica.in.progresso;


import com.bff.business.dto.escolademusica.enums.StatusTopico;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressoTopicoRequestDTO {

    private Long id;
    private Long topicoId;
    private Long progressoTopicoId;
    private String topicoNome;
    private StatusTopico status;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private boolean concluido;
    private int ordem;
    @Builder.Default
    private LocalDateTime ultimaAtualizacao = LocalDateTime.now();

    @Builder.Default
    private BigDecimal progresso = BigDecimal.ZERO;
}
