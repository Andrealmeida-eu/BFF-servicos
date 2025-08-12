package com.bff.business.dto.escolademusica.out.conteudo;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicoResponseDTO {



    private String nome;
    @Builder.Default
    private int ordem = 1;


    // Getters e Setters
}

