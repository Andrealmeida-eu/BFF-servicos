package com.bff_studio.alan_godoy.business.dto.escolademusica.in.instrumento;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.conteudo.DisciplinaRequestDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrumentoResumoDTO {
    private Long id;
    private String nome;
    private InstrumentoTipo tipo;
    private Integer quantidadeDeAluno;
    private List<DisciplinaRequestDTO> disciplinas;
    private Integer totalDisciplinas;
}
