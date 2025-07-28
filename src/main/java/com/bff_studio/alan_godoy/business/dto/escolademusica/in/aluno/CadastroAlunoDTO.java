package com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CadastroAlunoDTO {



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

    @NotNull
    private DayOfWeek diaSemanaAula;

    @NotNull
    private LocalTime horarioAula;

    private ProfessorRequestDTO professor;


    private List<AulaRequestDTO> aulas; // Mudar para AulaDTO

    @Builder.Default
    private LocalDate dataCadastro = LocalDate.now();
}
