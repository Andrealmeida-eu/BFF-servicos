package com.bff.business.dto.escolademusica.in.instrumento;


import com.bff.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff.business.dto.escolademusica.in.conteudo.DisciplinaRequestDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrumentoRequestDTO {
    private Long id;
    private String nome;
    private InstrumentoTipo tipo;
    private Integer quantidadeDeAluno;
    private List<DisciplinaRequestDTO> disciplinas;
}
