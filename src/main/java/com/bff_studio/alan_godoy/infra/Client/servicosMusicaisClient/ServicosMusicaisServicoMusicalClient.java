package com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient;

import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.CategoriaServicoResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.ServicoMusicalResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.ServicoMusicalResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "servicos-musicais-servicos", url = "${servicos-musicais.url}")
public interface ServicosMusicaisServicoMusicalClient {


    @GetMapping
    List<ServicoMusicalResponseDTO> listarTodosServicos(@RequestHeader("Authorization") String token);


    @GetMapping("/{id}")
    ServicoMusicalResponseDTO buscarServicosPorId(@PathVariable Long id,
                                                  @RequestHeader("Authorization") String token);

    @PostMapping
    ServicoMusicalResponseDTO criarServicos(@RequestBody ServicoMusicalResquestDTO dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/{id}")
    ServicoMusicalResponseDTO atualizarServicos(@PathVariable Long id,
                                                @RequestBody ServicoMusicalResquestDTO dto,
                                                @RequestHeader("Authorization") String token);

    @DeleteMapping("/{id}")
    void deletarServicos(@PathVariable Long id,
                         @RequestHeader("Authorization") String token);


    @PostMapping("/categoria/criar")
    CategoriaServicoResponseDTO criarCategoriaServico(@RequestBody CategoriaServicoResquestDTO dto,
                                                      @RequestHeader("Authorization") String token);

    @GetMapping("/categoria/listarAtivos")
    List<CategoriaServicoResponseDTO> listarCategoriaServicoAtivas(@RequestHeader("Authorization") String token);

    @GetMapping("/categoria/{id}/buscarId")
    CategoriaServicoResponseDTO buscarCatPorId(@PathVariable Long id,
                                               @RequestHeader("Authorization") String token);

    @PutMapping("categoria/{id}/atualizar")
    CategoriaServicoResponseDTO atualizarServicoCategoria(
            @PathVariable Long id,
            @RequestBody CategoriaServicoResquestDTO dto,
            @RequestHeader("Authorization") String token);

    @DeleteMapping("categoria/{id}/deletar")
    void inativar(@PathVariable Long id,
                  @RequestHeader("Authorization") String token);

    @PatchMapping("/categoria/{id}/parcial")
    CategoriaServicoResponseDTO atualizarParcialmenteCategoriaServico(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
