package com.bff.controller.escolademusica;


import com.bff.business.dto.escolademusica.out.receita.ReceitaResponseDTO;
import com.bff.business.services.escolademusica.ReceitaService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/escola-musica/receita")
@Tag(name = "Receita", description = "Operações relacionadas a receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    @GetMapping
    @Operation(summary = "Calcular receita", description = "Calcula a receita total em um período")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<ReceitaResponseDTO> calcularReceita(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(receitaService.calcularReceita(inicio, fim, token));
    }

    @GetMapping("pagas")
    @Operation(summary = "Contar mensalidades pagas", description = "Conta as mensalidades pagas em um período")
    @ApiResponse(responseCode = "200", description = "Contagem realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<Long> contarPagas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(receitaService.contarMensalidadesPagas(inicio, fim, token));
    }

    @GetMapping("nao-pagas")
    @Operation(summary = "Contar mensalidades não pagas", description = "Conta as mensalidades em aberto em um período")
    @ApiResponse(responseCode = "200", description = "Contagem realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<Long> contarNaoPagas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(receitaService.contarMensalidadesAbertas(inicio, fim, token));
    }
}
