package com.bff_studio.alan_godoy.business.dto.servicosmusicais.in;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoMusicalResquestDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoHora;
    private Integer horasEstimadas;
    private Long categoriaId;
  //  private TipoServico tipo;

    // Getters e Setters
}
