package com.bff.infra.Client.config;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioDisponivelDTO {


    private LocalDateTime dataHora;

    public String getDataHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

}
