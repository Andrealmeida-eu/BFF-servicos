package com.bff_studio.alan_godoy.business.dto.escolademusica.in.progresso;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConclusaoTopicoRequestDTO {
    @NotBlank
private String observacoes;
}

