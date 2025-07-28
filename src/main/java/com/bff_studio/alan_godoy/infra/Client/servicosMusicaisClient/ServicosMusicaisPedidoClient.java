package com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.enums.StatusPedido;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.PedidoResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.PedidoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "servicos-musicais-pedido", url = "${servicos-musicais.url}")
public interface ServicosMusicaisPedidoClient {

    @PostMapping
    PedidoResponseDTO criarPedido(@RequestBody PedidoResquestDTO dto,
                                  @RequestHeader("Authorization") String token);

    @PatchMapping("/{id}/status")
    PedidoResponseDTO atualizarStatusPedido(
            @PathVariable Long id,
            @RequestParam StatusPedido status,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<PedidoResponseDTO> listarTodosPedidos(@RequestHeader("Authorization") String token);


    @DeleteMapping("/{id}")
    void deletarPedido(@PathVariable Long id,
                       @RequestHeader("Authorization") String token);


    @PatchMapping("/pedido/{id}/parcial")
    PedidoResponseDTO atualizarPedidoParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
