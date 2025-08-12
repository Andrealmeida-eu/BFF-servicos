package com.bff.business.dto.escolademusica.out.instrumento;



import com.bff.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff.business.dto.escolademusica.out.conteudo.DisciplinaResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrumentoResponseDTO {

    private Long id;
    private String nome;
    private InstrumentoTipo tipo;
    private Integer quantidadeDeAluno;
    private List<DisciplinaResponseDTO> disciplinas;
}
