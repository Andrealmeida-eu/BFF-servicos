package com.bff_studio.alan_godoy.controller.servicosmusicais;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.ClienteResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.ClienteResponseDTO;
import com.bff_studio.alan_godoy.business.services.servicosmusicais.ClienteService;
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

@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/admin/servicos-musicais/clientes")
@Tag(name = "clientes", description = "Operações relacionadas a clientes")
public class ClienteController {


    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Criar cliente", description = "Cadastra um novo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<ClienteResponseDTO> criarCliente(@RequestBody ClienteResquestDTO dto,
                                                           @RequestHeader(name = "Authorization", required = false) String token) {
        ClienteResponseDTO clienteCriado = clienteService.criarCliente(dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }


    @GetMapping
    @Operation(summary = "Listar clientes", description = "Recupera todos os clientes cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ClienteResponseDTO>> listarTodosClientes(@RequestHeader(name = "Authorization", required = false) String token) {
        List<ClienteResponseDTO> clientes = clienteService.listarTodos(token);
        return ResponseEntity.ok(clientes);
    }


    @PutMapping("/{id}/up")
    @Operation(summary = "Atualizar cliente", description = "Atualiza todos os dados de um cliente")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id,
                                                        @RequestBody ClienteResquestDTO dto,
                                                        @RequestHeader(name = "Authorization", required = false) String token) {
        dto.setId(id);
        return ResponseEntity.ok(clienteService.criarCliente(dto, token));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente", description = "Remove um cliente pelo ID")
    @ApiResponse(responseCode = "204", description = "Cliente removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id,
                                               @RequestHeader(name = "Authorization", required = false) String token) {
        clienteService.deletar(id, token);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de um cliente")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    public ResponseEntity<ClienteResponseDTO> atualizarClienteParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(clienteService.atualizarParcialmente(id, updates, token));
    }
}
