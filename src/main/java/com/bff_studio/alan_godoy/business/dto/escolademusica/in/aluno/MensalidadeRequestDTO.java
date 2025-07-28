package com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusMensalidade;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MensalidadeRequestDTO {
    @NotNull(message = "Aluno é obrigatório")
    private Long alunoId;

    private Long id;

    private BigDecimal valor;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @Builder.Default
    private StatusMensalidade status = StatusMensalidade.ABERTA;

    // Getters e Setters
}