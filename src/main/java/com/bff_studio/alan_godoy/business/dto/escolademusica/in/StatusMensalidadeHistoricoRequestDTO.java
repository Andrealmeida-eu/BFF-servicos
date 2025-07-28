package com.bff_studio.alan_godoy.business.dto.escolademusica.in;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusMensalidade;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.MensalidadeRequestDTO;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusMensalidadeHistoricoRequestDTO {


    private Long id;
    private StatusMensalidade statusAnterior;
    private StatusMensalidade statusNovo;
    private LocalDate dataModificacao;
    private MensalidadeRequestDTO mensalidade;
}
