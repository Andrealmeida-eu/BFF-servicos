package com.bff.business.dto.loja.out;



import com.bff.business.dto.loja.enums.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimentacaoEstoqueResponseDTO {

    private String produtoNome;
    private Integer quantidade;
    private TipoMovimentacao tipo;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;

    // Getters e Setters
}
