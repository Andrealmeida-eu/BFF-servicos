package com.bff.controller.loja;


import com.bff.business.dto.loja.Specification.ProdutoFiltro;
import com.bff.business.dto.loja.in.ProdutoRequestDTO;
import com.bff.business.dto.loja.out.ProdutoResponseDTO;
import com.bff.business.services.loja.ProdutoService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ProdutoController.java
@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/admin/loja/produtos")
@Tag(name = "Produtos", description = "Operações administrativas relacionadas a produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar produtos", description = "Lista todos os produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosProdutos(@RequestHeader( name = "Authorization", required = false) String token) {
        System.out.println("Headers recebidos: {}" + token);
        return ResponseEntity.ok(produtoService.listarTodos(token));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto", description = "Recupera um produto pelo ID")
    @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutosPorId(@PathVariable Long id,
                                                                  @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(produtoService.buscarPorId(id, token));
    }

    @PostMapping
    @Operation(summary = "Cadastrar produto", description = "Cria um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<ProdutoResponseDTO> salvarProdutos(@RequestBody ProdutoRequestDTO dto,
                                                             @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(dto, token));
    }

    @PutMapping("/{id}/up")
    @Operation(summary = "Atualizar produto", description = "Atualiza todos os dados de um produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoResponseDTO> atualizarProdutos(@PathVariable Long id,
                                                                @RequestBody ProdutoRequestDTO dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        dto.setId(id);
        return ResponseEntity.ok(produtoService.salvar(dto, token));
    }

    @DeleteMapping("/{id}/deletar")
    @Operation(summary = "Deletar produto", description = "Remove um produto pelo ID")
    @ApiResponse(responseCode = "204", description = "Produto removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> deletarProdutos(@PathVariable Long id,
                                                @RequestHeader(name = "Authorization", required = false) String token) {
        produtoService.deletar(id, token);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adicionar-estoque")
    @Operation(summary = "Adicionar estoque", description = "Adiciona quantidade ao estoque de um produto")
    @ApiResponse(responseCode = "200", description = "Estoque atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Quantidade inválida")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> adicionarEstoque(@PathVariable Long id,
                                                 @RequestParam Integer quantidade,
                                                 @RequestHeader(name = "Authorization", required = false) String token) {
        produtoService.adicionarEstoque(id, quantidade, token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/remover-estoque")
    @Operation(summary = "Remover estoque", description = "Remove quantidade do estoque de um produto")
    @ApiResponse(responseCode = "200", description = "Estoque atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Quantidade inválida ou insuficiente")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> removerEstoque(@PathVariable Long id,
                                               @RequestParam Integer quantidade,
                                               @RequestHeader(name = "Authorization", required = false) String token) {
        produtoService.removerEstoque(id, quantidade, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza os dados de um produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(
            @PathVariable Long id,
            @Validated @RequestBody ProdutoRequestDTO produtoDTO,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDTO, token));
    }

    @GetMapping("/pesquisar")
    @Operation(summary = "Pesquisar produtos", description = "Pesquisa produtos com filtros específicos")
    @ApiResponse(responseCode = "200", description = "Pesquisa realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Filtros inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<ProdutoResponseDTO>> pesquisarProdutos(
            @ModelAttribute ProdutoFiltro filtro,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(produtoService.pesquisarProdutos(filtro, token));
    }
}
