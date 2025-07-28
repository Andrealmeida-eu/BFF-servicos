package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.receita.CategoriaDespesasRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.receita.CategoriaDespesasResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.CategoriaDespesasService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping ("/admin/escola-musica/categoria")
@RequiredArgsConstructor
@Tag(name = "Categorias de Despesas", description = "Operações relacionadas a categorias de despesas")
public class CategoriaDespesaController {

    private final CategoriaDespesasService categoriaService;


    @PostMapping
    @Operation(summary = "Criar categoria", description = "Cadastra uma nova categoria de despesa")
    @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public CategoriaDespesasResponseDTO criarCategoriaDespesas(@RequestBody CategoriaDespesasRequestDTO categoriaDTO,
                                             @RequestHeader(name = "Authorization", required = false) String token) {
        return categoriaService.criarCategoriaDespesa(categoriaDTO, token);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria de despesa")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public CategoriaDespesasResponseDTO atualizarCategoriaDespesa(@PathVariable Long id,
                                                                  @RequestBody CategoriaDespesasRequestDTO categoriaDTO,
                                                                 @RequestHeader(name = "Authorization", required = false) String token) {
        return categoriaService.atualizarCategoriaDespesa(id, categoriaDTO, token);
    }

    @GetMapping
    @Operation(summary = "Listar categorias", description = "Lista todas as categorias de despesas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public List<CategoriaDespesasResponseDTO> listarTodasCatDespesas(@RequestHeader(name = "Authorization", required = false) String token) {
        return categoriaService.listarTodasCategoriaDespesa(token);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria", description = "Recupera os dados de uma categoria específica")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public CategoriaDespesasResponseDTO buscarCatDespesaPorId(@PathVariable Long id,
                                                             @RequestHeader(name = "Authorization", required = false) String token) {
        return categoriaService.buscarCatDespesaPorId(id, token);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar categoria", description = "Remove uma categoria de despesa")
    @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public void deletarCatDespesa(@PathVariable Long id,
                                 @RequestHeader(name = "Authorization", required = false) String token) {
        categoriaService.deletarCategoriaDespesa(id, token);
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de uma categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    public ResponseEntity<CategoriaDespesasResponseDTO> atualizarParcialmenteCatDespesa(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
           @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(categoriaService.atualizarCatDespesaParcialmente(id, updates, token));

    }
}
