package com.bff.business.dto.escolademusica.out;


import com.bff.business.dto.escolademusica.enums.StatusReposicao;
import com.bff.business.dto.escolademusica.enums.TipoAula;
import com.bff.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReposicaoResponseDTO {

private Long id;
    @JsonIgnore
    private AulaResponseDTO aulaReposicao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime novaDataHora;

    private String motivo;

    @Builder.Default
    private StatusReposicao status = StatusReposicao.PENDENTE;
    private TipoAula tipoAula;

    @Builder.Default

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataSolicitacao = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHoraAulaOriginal;

    private String alunoNome;

    // Getters e Setters
}
