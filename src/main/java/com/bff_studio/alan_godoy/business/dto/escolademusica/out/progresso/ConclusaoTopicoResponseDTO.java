package com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConclusaoTopicoResponseDTO {
    @NotBlank
private String observacoes;
}

