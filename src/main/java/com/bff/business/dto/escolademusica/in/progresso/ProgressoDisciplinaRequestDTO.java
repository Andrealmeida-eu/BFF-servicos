package com.bff.business.dto.escolademusica.in.progresso;


import com.bff.business.dto.escolademusica.enums.StatusProgresso;
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
public class ProgressoDisciplinaRequestDTO {

    private Long id;
    private String nome;
    private Long disciplinaId;
    private String disciplinaNome;
    private StatusProgresso status;
    private boolean concluida;
    private LocalDate dataConclusao;    private LocalDate dataInicio;
    private BigDecimal progresso;
    private int concluidos;
    private int total;
    private List<ProgressoTopicoRequestDTO> topicos;

    // Novo campo para mostrar se está completa
    public boolean isCompleta() {
        return topicos != null && !topicos.isEmpty() &&
                topicos.stream().allMatch(ProgressoTopicoRequestDTO::isConcluido);
    }

}
