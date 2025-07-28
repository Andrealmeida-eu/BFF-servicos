package com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ConfigResponseDTO {

    private BigDecimal valorMensalidade;
    private Integer diaVencimento;


}
