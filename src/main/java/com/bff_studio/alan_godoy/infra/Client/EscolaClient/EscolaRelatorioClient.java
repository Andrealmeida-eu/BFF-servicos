package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.in.RelatorioAulaRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.RelatorioAulaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-relatorio", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaRelatorioClient {


    @PostMapping
    RelatorioAulaResponseDTO criarRelatorio(
            @RequestBody RelatorioAulaRequestDTO dto,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<RelatorioAulaResponseDTO> listarRelatorios(
            @RequestParam(required = false) Long professorId,
            @RequestParam(required = false) Long alunoId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestHeader("Authorization") String token);

    @PatchMapping("/{id}/parcial")
    RelatorioAulaResponseDTO atualizarRelatorioParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String,
                    Object> updates,
            @RequestHeader("Authorization") String token);

}
