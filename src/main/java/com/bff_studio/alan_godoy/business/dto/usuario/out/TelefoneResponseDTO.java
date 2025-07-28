package com.bff_studio.alan_godoy.business.dto.usuario.out;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneResponseDTO {

    private String numero;
    private String ddd;

}
