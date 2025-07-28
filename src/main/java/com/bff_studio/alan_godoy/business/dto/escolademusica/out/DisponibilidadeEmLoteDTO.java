package com.bff_studio.alan_godoy.business.dto.escolademusica.out;

import lombok.*;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisponibilidadeEmLoteDTO {
    private List<DayOfWeek> diasSemana;
    private List<HorarioDTO> horarios;
}

