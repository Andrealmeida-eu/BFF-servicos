package com.bff.business.dto.servicosmusicais.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponseDTO {


    private String nome;
    private String email;
    private String telefone;

}
