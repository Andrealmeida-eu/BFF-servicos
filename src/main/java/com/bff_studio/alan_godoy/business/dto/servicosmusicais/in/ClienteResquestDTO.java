package com.bff_studio.alan_godoy.business.dto.servicosmusicais.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResquestDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
