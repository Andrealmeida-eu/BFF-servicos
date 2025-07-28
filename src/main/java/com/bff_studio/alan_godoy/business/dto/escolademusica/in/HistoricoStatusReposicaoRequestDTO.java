package com.bff_studio.alan_godoy.business.dto.escolademusica.in;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusReposicao;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoStatusReposicaoRequestDTO {

    private Long id;
    private LocalDateTime dataAlteracao;
    private StatusReposicao statusAnterior;
    private StatusReposicao novoStatus;
}
