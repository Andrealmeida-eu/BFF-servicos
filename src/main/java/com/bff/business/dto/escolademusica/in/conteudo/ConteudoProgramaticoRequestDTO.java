package com.bff.business.dto.escolademusica.in.conteudo;



import com.bff.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ConteudoProgramaticoRequestDTO {

    private Long id;
    @NotNull
    private Long instrumentoId;
    private String instrumentoNome;
  private InstrumentoRequestDTO instrumento;

    @Valid
    @NotEmpty(message = "Deve conter pelo menos uma disciplina")
    private List<DisciplinaRequestDTO> disciplinas;

    // Getters e Setters
}

