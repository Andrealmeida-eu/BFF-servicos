package com.bff.business.dto.escolademusica.out.aluno;


import com.bff.business.dto.escolademusica.enums.StatusMensalidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MensalidadeResponseDTO {

private Long id;
    private BigDecimal valor;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;
    @Builder.Default
    private StatusMensalidade status = StatusMensalidade.ABERTA;

    private String dataPagamento; // Armazena "Aguardando Pagamento" ou "dd/MM/yyyy"

    /* Getter customizado para converter em LocalDate (se necessário)
    public LocalDate getDataPagamentoAsLocalDate() {
        if ("Aguardando Pagamento".equals(dataPagamento)) {
            return null;
        }
        return LocalDate.parse(dataPagamento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // Getters e Setters
    }

     */
}