package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.in.receita.DespesasRequestDTO;
import com.bff.business.dto.escolademusica.out.receita.DespesasResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-despesa", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaDespesaClient {


    // ========== ENDPOINTS DESPESA_CONTROLLER ========== //

    @PostMapping("/admin/escola-musica/despesas")
    DespesasResponseDTO criarDespesa(@RequestBody DespesasRequestDTO despesasDTO,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas")
    List<DespesasResponseDTO> listarTodasDespesas(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas/periodo")
    List<DespesasResponseDTO> listarDespesasPorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas/total-periodo")
    BigDecimal calcularTotalDespesasPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas/por-categoria/{categoriaId}")
    List<DespesasResponseDTO> listarDespesasPorCategoria(@PathVariable Long categoriaId,
                                                         @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas/por-categoria-periodo")
    List<DespesasResponseDTO> listarDespesasPorCategoriaEPeriodo(
            @RequestParam Long categoriaId,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/despesas/total-por-categoria")
    BigDecimal calcularTotalDespesasPorCategoria(
            @RequestParam Long categoriaId,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim,
            @RequestHeader("Authorization") String token);

    @PatchMapping("/admin/escola-musica/despesas/{id}/parcial")
    DespesasResponseDTO atualizarDespesasParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);

}
