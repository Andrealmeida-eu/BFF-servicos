package com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoRequestDTO {


    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank // @CPF
    private String cpf;


    @Email
    @NotBlank
    private String email;

    private String telefone;

    @NotNull
    private Long instrumentoId;

    private Long mensalidadeId;
    private MensalidadeRequestDTO mensalidade;
    private InstrumentoRequestDTO instrumento;

    @NotNull
    private DayOfWeek diaSemanaAula;

    @NotNull
    private LocalTime horarioAula;

    private ProfessorRequestDTO professor;



    private Set<AulaRequestDTO> aulas;

    @Builder.Default
    private LocalDate dataCadastro = LocalDate.now();
}