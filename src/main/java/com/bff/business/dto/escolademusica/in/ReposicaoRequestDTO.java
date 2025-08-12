package com.bff.business.dto.escolademusica.in;


import com.bff.business.dto.escolademusica.enums.StatusReposicao;
import com.bff.business.dto.escolademusica.enums.TipoAula;
import com.bff.business.dto.escolademusica.in.aluno.AulaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReposicaoRequestDTO {

    private Long id;

    @NotNull(message = "Aluno é obrigatório")
    private Long aulaOriginalId;

    @JsonIgnore
    private AulaRequestDTO aulaReposicao;

    @Future(message = "Nova data deve ser no futuro")
    private LocalDateTime novaDataHora;
    private TipoAula tipoAula;


    @NotBlank(message = "Motivo é obrigatório")
    @Size(max = 500, message = "Motivo deve ter no máximo 500 caracteres")
    private String motivo;

    @Builder.Default
    private StatusReposicao status = StatusReposicao.PENDENTE;

    @Builder.Default
    private LocalDateTime dataSolicitacao = LocalDateTime.now();


    // Getters e Setters
}
