package com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusProgresso;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressoAlunoResponseDTO {

    private Long id;
    private Long alunoId;
    private String alunoNome;
    private Long instrumentoId;
    private String instrumentoNome;
    private StatusProgresso status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate ultimaAtualizacao;
    private Double percentualConclusao;
    private List<ProgressoDisciplinaResponseDTO> disciplinas;
}
