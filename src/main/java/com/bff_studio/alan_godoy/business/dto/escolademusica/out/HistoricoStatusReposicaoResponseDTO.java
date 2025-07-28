package com.bff_studio.alan_godoy.business.dto.escolademusica.out;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusReposicao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoStatusReposicaoResponseDTO {

    private Long id;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAlteracao;
    private StatusReposicao statusAnterior;
    private StatusReposicao novoStatus;
}
