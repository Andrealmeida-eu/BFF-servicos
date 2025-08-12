package com.bff.business.dto.usuario.out;

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
