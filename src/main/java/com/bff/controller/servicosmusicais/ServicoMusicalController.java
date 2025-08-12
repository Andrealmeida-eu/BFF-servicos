package com.bff.controller.servicosmusicais;

import com.bff.business.dto.servicosmusicais.in.CategoriaServicoResquestDTO;
import com.bff.business.dto.servicosmusicais.in.ServicoMusicalResquestDTO;
import com.bff.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff.business.dto.servicosmusicais.out.ServicoMusicalResponseDTO;
import com.bff.business.services.servicosmusicais.CategoriaServicoService;
import com.bff.business.services.servicosmusicais.ServicoMusicalService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

@RequiredArgsConstructor
@RequestMapping("/servicos-musicais/servico")
@Tag(name = "servicos", description = "Operações relacionadas a serviços musicais")
public class ServicoMusicalController {

    private final ServicoMusicalService service;
    private final CategoriaServicoService catService;

    @GetMapping
    @Operation(summary = "Listar serviços", description = "Recupera todos os serviços cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de serviços retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ServicoMusicalResponseDTO>> listarTodosServicos(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.listarTodos(token));
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço", description = "Recupera um serviço pelo ID")
    @ApiResponse(responseCode = "200", description = "Serviço encontrado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<ServicoMusicalResponseDTO> buscarServicosPorId(@PathVariable Long id,
                                                                         @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.buscarPorId(id, token));
    }

    @PostMapping
    @Operation(summary = "Criar serviço", description = "Cadastra um novo serviço musical")
    @ApiResponse(responseCode = "201", description = "Serviço criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<ServicoMusicalResponseDTO> criarServicos(@RequestBody ServicoMusicalResquestDTO dto,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto, token));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar serviço", description = "Atualiza todos os dados de um serviço")
    @ApiResponse(responseCode = "200", description = "Serviço atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<ServicoMusicalResponseDTO> atualizarServicos(@PathVariable Long id,
                                                                       @RequestBody ServicoMusicalResquestDTO dto,
                                                                       @RequestHeader(name = "Authorization", required = false) String token) {
        ServicoMusicalResponseDTO response = service.salvar(dto, token);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar serviço", description = "Remove um serviço pelo ID")
    @ApiResponse(responseCode = "204", description = "Serviço removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<Void> deletarServicos(@PathVariable Long id,
                                                @RequestHeader(name = "Authorization", required = false) String token) {
        service.deletar(id, token);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/categoria/criar")
    @Operation(summary = "Criar categoria", description = "Cadastra uma nova categoria de serviço")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<CategoriaServicoResponseDTO> criarCategoriaServico(@RequestBody CategoriaServicoResquestDTO dto,
                                                                             @RequestHeader(name = "Authorization", required = false) String token) {
        CategoriaServicoResponseDTO categoria = catService.criar(dto, token);
        return ResponseEntity.created(URI.create("/api/categorias-servico/" + dto.getId()))
                .body(categoria);
    }

    @GetMapping("/categoria/listarAtivos")
    @Operation(summary = "Listar categorias ativas", description = "Recupera todas as categorias de serviço ativas")
    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<CategoriaServicoResponseDTO>> listarCategoriaServicoAtivas(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(catService.listarTodasAtivas(token));
    }

    @GetMapping("/categoria/{id}/buscarId")
    @Operation(summary = "Buscar categoria", description = "Recupera uma categoria de serviço pelo ID")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaServicoResponseDTO> buscarCatPorId(@PathVariable Long id,
                                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(catService.buscarPorId(id, token));
    }

    @PutMapping("categoria/{id}/atualizar")
    @Operation(summary = "Atualizar categoria", description = "Atualiza todos os dados de uma categoria de serviço")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaServicoResponseDTO> atualizarServicoCategoria(
            @PathVariable Long id,
            @RequestBody CategoriaServicoResquestDTO dto,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(catService.atualizar(id, dto, token));
    }

    @DeleteMapping("categoria/{id}/deletar")
    @Operation(summary = "Inativar categoria", description = "Inativa uma categoria de serviço")
    @ApiResponse(responseCode = "204", description = "Categoria inativada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<Void> inativar(@PathVariable Long id,
                                         @RequestHeader(name = "Authorization", required = false) String token) {
        catService.inativar(id, token);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/categoria/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de uma categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaServicoResponseDTO> atualizarParcialmenteCategoriaServico(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.atualizarParcialmente(id, updates, token));
    }

}
