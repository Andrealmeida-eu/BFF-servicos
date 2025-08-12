package com.bff.business.dto.escolademusica.out.conteudo;



import com.bff.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ConteudoProgramaticoResponseDTO {


    private String instrumentoNome;
    private InstrumentoRequestDTO instrumento;
    private List<DisciplinaResponseDTO> disciplinas;

    // Getters e Setters
}

