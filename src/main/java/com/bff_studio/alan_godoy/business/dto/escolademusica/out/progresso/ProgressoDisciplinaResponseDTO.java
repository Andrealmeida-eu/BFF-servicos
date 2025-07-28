package com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusProgresso;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProgressoDisciplinaResponseDTO {

    private Long id;
    private Long disciplinaId;
    private String disciplinaNome;
    private StatusProgresso status;
    private boolean concluida;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    private BigDecimal progresso;
    private int concluidos;
    private int total;
    private List<ProgressoTopicoResponseDTO> topicos;

    // Novo campo para mostrar se está completa
    public boolean isCompleta() {
        return topicos != null && !topicos.isEmpty() &&
                topicos.stream().allMatch(ProgressoTopicoResponseDTO::isConcluido);
    }

}
