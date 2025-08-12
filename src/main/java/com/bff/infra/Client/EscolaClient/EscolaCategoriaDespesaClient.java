package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.in.receita.CategoriaDespesasRequestDTO;
import com.bff.business.dto.escolademusica.out.receita.CategoriaDespesasResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-categoria-despesa", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaCategoriaDespesaClient {


    //ENDPOINTS CATEGORIA_DESPESA_CONTROLLER

    @PostMapping("/admin/escola-musica/categoria")
    CategoriaDespesasResponseDTO criarCategoriaDespesas(@RequestBody CategoriaDespesasRequestDTO categoriaDTO,
                                                        @RequestHeader("Authorization") String token);

    @PutMapping("/admin/escola-musica/categoria/{id}")
    CategoriaDespesasResponseDTO atualizarCategoriaDespesa(@PathVariable Long id,
                                                           @RequestBody CategoriaDespesasRequestDTO categoriaDTO,
                                                           @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/categoria")
    List<CategoriaDespesasResponseDTO> listarTodasCatDespesas(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/categoria/{id}")
    CategoriaDespesasResponseDTO buscarCatDespesaPorId(@PathVariable Long id,
                                                       @RequestHeader("Authorization") String token);

    @DeleteMapping("/admin/escola-musica/categoria/{id}")
    void deletarCatDespesa(@PathVariable Long id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping("/admin/escola-musica/categoria/{id}/parcial")
    CategoriaDespesasResponseDTO atualizarParcialmenteCatDespesa(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
