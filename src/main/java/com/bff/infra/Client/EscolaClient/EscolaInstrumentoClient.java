package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import com.bff.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-instrumento", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaInstrumentoClient {

    // ========== ENDPOINTS INSTRUMENTO_CONTROLLER ========== //

    @PostMapping("/admin/escola-musica/instrumentos")
    InstrumentoResponseDTO cadastrarIsntrumentos(
            @RequestBody InstrumentoRequestDTO instrumentoDTO,
            @RequestHeader("Authorization") String token);


    @GetMapping("/admin/escola-musica/instrumentos/categoria/{categoria}")
    List<InstrumentoResponseDTO> listarIsntrumentosPorCategoria(
            @PathVariable InstrumentoTipo categoria,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/instrumentos")
    List<InstrumentoResponseDTO> listarTodosInstrumentos(@RequestHeader("Authorization") String token);

    @PatchMapping("/admin/escola-musica/instrumentos/{id}/parcial")
    InstrumentoResponseDTO atualizarIsntrumentosParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
