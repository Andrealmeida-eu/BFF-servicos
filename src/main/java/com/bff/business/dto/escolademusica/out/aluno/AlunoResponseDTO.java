package com.bff.business.dto.escolademusica.out.aluno;


import com.bff.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoResponseDTO {

    private Long id;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank // @CPF
    private String cpf;
    @Email
    @NotBlank
    private String email;
    private String telefone;
    @Builder.Default

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();
    @NotNull
    private DayOfWeek diaSemanaAula;
    @NotNull

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horarioAula;
    private ProfessorResponseDTO professor;
    private InstrumentoResponseDTO instrumento;
    @Builder.Default
    private Set<AulaResponseDTO> aulas = new HashSet<>();
    @Builder.Default
    private Set<MensalidadeResponseDTO> mensalidades = new HashSet<>();
}