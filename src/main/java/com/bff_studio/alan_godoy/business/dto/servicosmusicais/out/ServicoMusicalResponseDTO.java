package com.bff_studio.alan_godoy.business.dto.servicosmusicais.out;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoMusicalResponseDTO {

    private String nome;
    private String descricao;
    private BigDecimal precoHora;
    private Integer horasEstimadas;


    // Getters e Setters
}
