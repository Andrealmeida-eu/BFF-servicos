package com.bff_studio.alan_godoy.business.dto.escolademusica.out;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusMensalidade;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.MensalidadeResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusMensalidadeHistoricoResponseDTO {



    private StatusMensalidade statusAnterior;
    private StatusMensalidade statusNovo;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataModificacao;
    private MensalidadeResponseDTO mensalidade;
}
