package com.bff_studio.alan_godoy.business.dto.escolademusica.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatorioAulaResponseDTO {



    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAula;
    private String descricao;
    @Builder.Default

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String nomeProfessor;
    private String nomeAluno;
    // Getters e Setters
}