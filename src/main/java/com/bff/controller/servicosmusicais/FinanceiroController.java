package com.bff.controller.servicosmusicais;


import com.bff.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff.business.services.servicosmusicais.FinanceiroService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

@RequiredArgsConstructor
@RequestMapping("/admin/servicos-musicais/receita")
@Tag(name = "financeiro", description = "Operações relacionadas ao financeiro")
public class FinanceiroController {

    private final FinanceiroService service;

    @GetMapping("/total")
    @Operation(summary = "Receita total", description = "Calcula a receita total de todos os serviços")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<BigDecimal> receitaTotal(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.calcularReceitaTotal(token));
    }

    @GetMapping("/periodo")
    @Operation(summary = "Receita por período", description = "Calcula a receita em um período específico")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<BigDecimal> receitaPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.calcularReceitaPeriodo(inicio, fim, token));
    }


    @GetMapping("/receita-por-servico")
    @Operation(summary = "Receita por serviço", description = "Calcula a receita agrupada por tipo de serviço")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "204", description = "Nenhum dado disponível")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    public ResponseEntity<?> receitaPorTipoServico(@RequestHeader(name = "Authorization", required = false) String token) {
        try {
            Map<CategoriaServicoResponseDTO, BigDecimal> resultado = service.calcularReceitaPorTipoServico(token);

            if (resultado.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            // Transforma o Map em uma lista de objetos para melhor resposta JSON
            List<Map<String, Object>> response = resultado.entrySet().stream()
                    .map(entry -> {
                        Map<String, Object> item = new LinkedHashMap<>();
                        item.put("categoria", entry.getKey());
                        item.put("receitaTotal", entry.getValue());
                        return item;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao calcular receita por serviço: " + e.getMessage());
        }
    }


}
