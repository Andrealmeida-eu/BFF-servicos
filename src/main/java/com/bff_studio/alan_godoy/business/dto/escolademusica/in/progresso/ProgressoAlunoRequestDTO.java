package com.bff_studio.alan_godoy.business.dto.escolademusica.in.progresso;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusProgresso;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressoAlunoRequestDTO {

    private Long id;
    private Long alunoId;
    private String alunoNome;
    private Long instrumentoId;
    private String instrumentoNome;
    private InstrumentoRequestDTO instrumento;
    private StatusProgresso status;
    private LocalDate dataInicio;

    private LocalDate ultimaAtualizacao;
    private Double percentualConclusao;
    private List<ProgressoDisciplinaRequestDTO> disciplinas;
}
