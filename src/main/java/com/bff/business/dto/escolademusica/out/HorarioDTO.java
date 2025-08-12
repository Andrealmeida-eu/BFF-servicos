package com.bff.business.dto.escolademusica.out;

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
