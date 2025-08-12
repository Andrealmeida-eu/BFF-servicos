package com.bff.controller.escolademusica;


import com.bff.business.dto.escolademusica.in.receita.DespesasRequestDTO;
import com.bff.business.dto.escolademusica.out.receita.DespesasResponseDTO;
import com.bff.business.services.escolademusica.DespesaService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/admin/escola-musica/despesas")
@RequiredArgsConstructor
@Tag(name = "Despesas", description = "Operações relacionadas a despesas")
public class DespesasController {
    private final DespesaService despesaService;


    @PostMapping
    @Operation(summary = "Criar despesa", description = "Registra uma nova despesa")
    @ApiResponse(responseCode = "200", description = "Despesa criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public DespesasResponseDTO criarDespesa(@RequestBody DespesasRequestDTO despesasDTO,
                                          @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.criarDespesa(despesasDTO, token);
    }

    @GetMapping
    @Operation(summary = "Listar despesas", description = "Lista todas as despesas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public List<DespesasResponseDTO> listarTodasDespesas(@RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.listarTodas(token);
    }

    @GetMapping("/periodo")
    @Operation(summary = "Despesas por período", description = "Lista despesas em um período específico")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public List<DespesasResponseDTO> listarDespesasPorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.listarPorPeriodo(inicio, fim, token);
    }

    @GetMapping("/total-periodo")
    @Operation(summary = "Total de despesas", description = "Calcula o total de despesas em um período")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public BigDecimal calcularTotalDespesasPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.calcularTotalDespesasPeriodo(inicio, fim, token);
    }

    @GetMapping("/por-categoria/{categoriaId}")
    @Operation(summary = "Despesas por categoria", description = "Lista despesas de uma categoria específica")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public List<DespesasResponseDTO> listarDespesasPorCategoria(@PathVariable Long categoriaId,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.listarPorCategoria(categoriaId, token);
    }

    @GetMapping("/por-categoria-periodo")
    @Operation(summary = "Despesas por categoria e período", description = "Lista despesas de uma categoria em um período")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public List<DespesasResponseDTO> listarDespesasPorCategoriaEPeriodo(
            @RequestParam Long categoriaId,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.listarPorCategoriaEPeriodo(categoriaId, inicio, fim, token);
    }

    @GetMapping("/total-por-categoria")
    @Operation(summary = "Total por categoria", description = "Calcula o total de despesas de uma categoria em um período")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public BigDecimal calcularTotalDespesasPorCategoria(
            @RequestParam Long categoriaId,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return despesaService.calcularTotalPorCategoria(categoriaId, inicio, fim, token);
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de uma despesa")
    @ApiResponse(responseCode = "200", description = "Despesa atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Despesa não encontrada")
    public ResponseEntity<DespesasResponseDTO> atualizarDespesasParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(despesaService.atualizarParcialmente(id, updates, token));

    }
}
