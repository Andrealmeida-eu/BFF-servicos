package com.bff_studio.alan_godoy.controller.servicosmusicais;



import com.bff_studio.alan_godoy.business.dto.servicosmusicais.enums.StatusPedido;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.PedidoResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.PedidoResponseDTO;
import com.bff_studio.alan_godoy.business.services.servicosmusicais.PedidoService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

@RequiredArgsConstructor
@RequestMapping("/servicos-musicais/Pedido")
@Tag(name = "pedidos", description = "Operações relacionadas a pedidos")
public class PedidoController {
    private final PedidoService service;

    @PostMapping
    @Operation(summary = "Criar pedido", description = "Cadastra um novo pedido")
    @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<PedidoResponseDTO> criarPedido( @RequestBody PedidoResquestDTO dto,
                                                  @RequestHeader(name = "Authorization", required = false) String token) {
        PedidoResponseDTO pedidoCriado = service.criarPedido(dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Atualizar status", description = "Atualiza o status de um pedido")
    @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Status inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    public ResponseEntity<PedidoResponseDTO> atualizarStatusPedido(
            @PathVariable Long id,
            @RequestParam StatusPedido status,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.atualizarStatus(id, status, token));
    }


    @GetMapping
    @Operation(summary = "Listar pedidos", description = "Recupera todos os pedidos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<PedidoResponseDTO>> listarTodosPedidos(@RequestHeader(name = "Authorization", required = false) String token) {
        List<PedidoResponseDTO> pedidos = service.listarTodos(token);
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pedido", description = "Remove um pedido pelo ID")
    @ApiResponse(responseCode = "204", description = "Pedido removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id,
                                      @RequestHeader(name = "Authorization", required = false) String token) {
        service.deletar(id, token);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/pedido/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de um pedido")
    @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    public ResponseEntity<PedidoResponseDTO> atualizarPedidoParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.atualizarParcialmente(id, updates, token));
    }



}
