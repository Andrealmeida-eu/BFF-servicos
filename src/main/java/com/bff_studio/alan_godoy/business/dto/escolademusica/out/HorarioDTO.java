package com.bff_studio.alan_godoy.business.dto.escolademusica.out;

import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioDTO {
    private LocalTime horaInicio;
    private LocalTime horaFim;
}
