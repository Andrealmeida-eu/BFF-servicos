package com.bff.business.dto.escolademusica.out.aluno;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ConfigResponseDTO {

    private BigDecimal valorMensalidade;
    private Integer diaVencimento;


}
