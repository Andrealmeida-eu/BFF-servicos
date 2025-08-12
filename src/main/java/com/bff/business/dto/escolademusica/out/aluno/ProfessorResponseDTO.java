package com.bff.business.dto.escolademusica.out.aluno;

import com.bff.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorResponseDTO {


    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @Builder.Default
    private Set<InstrumentoResponseDTO> instrumentos = new HashSet<>();
    private Set<Long> instrumentosIds;
}
