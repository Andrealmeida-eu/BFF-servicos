package com.bff.infra.Client.servicosMusicaisClient;

import com.bff.business.dto.servicosmusicais.in.ClienteResquestDTO;
import com.bff.business.dto.servicosmusicais.out.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "servicos-musicais-cliente", url = "${servicos-musicais.url}")
public interface ServicosMusicaisClienteClient {

    @PostMapping("/servicos-musicais/clientes")
    ClienteResponseDTO criarCliente(@RequestBody ClienteResquestDTO dto,
                                    @RequestHeader("Authorization") String token);


    @GetMapping("/servicos-musicais/clientes")
    List<ClienteResponseDTO> listarTodosClientes(@RequestHeader("Authorization") String token);


    @PutMapping("/servicos-musicais/clientes/{id}/up")
    ClienteResponseDTO atualizar(@PathVariable Long id,
                                 @RequestBody ClienteResquestDTO dto,
                                 @RequestHeader("Authorization") String token);

    @DeleteMapping("/servicos-musicais/clientes/{id}")
    void deletarCliente(@PathVariable Long id,
                 @RequestHeader("Authorization") String token);

    @PatchMapping("/servicos-musicais/clientes/{id}/parcial")
    ClienteResponseDTO atualizarClienteParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
