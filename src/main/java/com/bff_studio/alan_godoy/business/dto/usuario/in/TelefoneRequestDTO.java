package com.bff_studio.alan_godoy.business.dto.usuario.in;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneRequestDTO {

    private Long id;
    private String numero;
    private String ddd;

}
