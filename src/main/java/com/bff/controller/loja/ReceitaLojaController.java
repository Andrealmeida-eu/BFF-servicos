package com.bff.controller.loja;


import com.bff.business.dto.loja.out.ReceitaMensalDTO;
import com.bff.business.dto.loja.out.ReceitaResponseDTO;
import com.bff.business.services.loja.ReceitaLojaService;
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
import java.util.Collections;
import java.util.List;

// ReceitaController.java
@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/admin/loja/receita")
@Tag(name = "Receitas da Loja", description = "Operações relacionadas às receitas da loja")
@RequiredArgsConstructor
public class ReceitaLojaController {

    private final ReceitaLojaService receitaService;

    @GetMapping
    @Operation(summary = "Calcular receita", description = "Calcula a receita total em um período específico")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<ReceitaResponseDTO> calcularReceitaLoja(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(receitaService.calcularReceita(inicio, fim, token));
    }

    @GetMapping("/mensal/{ano}")
    @Operation(summary = "Receita mensal", description = "Calcula a receita mensal para um ano específico")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "204", description = "Nenhum dado encontrado")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<ReceitaMensalDTO>> calcularReceitaMensalLoja(
            @PathVariable int ano,
            @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReceitaMensalDTO> receitas = receitaService.calcularReceitaMensal(ano, token);

        if (receitas.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList()); // Retorna 200 com lista vazia
        }

        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/mensal/{ano}/{mes}")
    @Operation(summary = "Receita do mês", description = "Recupera a receita de um mês específico")
    @ApiResponse(responseCode = "200", description = "Dados retornados com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Dados não encontrados")
    public ResponseEntity<ReceitaMensalDTO> getReceitaDoMesLoja(
            @PathVariable int ano,
            @PathVariable int mes,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(receitaService.consultarReceitaDoMes(ano, mes, token));
    }

}
