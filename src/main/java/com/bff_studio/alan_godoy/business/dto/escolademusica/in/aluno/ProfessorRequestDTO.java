package com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorRequestDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank // @CPF
    private String cpf;

    @Email
    @NotBlank
    private String email;

   // @Pattern(regexp = "...")
    private String telefone;

    private Long instrumentoId;
    private InstrumentoRequestDTO instrumento;
    @Builder.Default
    private Set<Long> instrumentosIds = new HashSet<>();
}
