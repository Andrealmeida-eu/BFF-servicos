package com.bff_studio.alan_godoy.infra.Client.lojaClient;

import com.bff_studio.alan_godoy.business.dto.loja.Specification.ProdutoFiltro;
import com.bff_studio.alan_godoy.business.dto.loja.in.ProdutoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.ProdutoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "loja-produto", url = "${loja.url}")
public interface LojaProdutoClient {
    @GetMapping("/admin/loja/produtos")
    List<ProdutoResponseDTO> listarTodosProdutos(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/loja/produtos/{id}")
    ProdutoResponseDTO buscarProdutosPorId(@PathVariable Long id,
                                           @RequestHeader("Authorization") String token);

    @PostMapping("admin/loja/produtos")
    ProdutoResponseDTO salvarProdutos(@RequestBody ProdutoRequestDTO dto,
                                      @RequestHeader("Authorization") String token);

    @PutMapping("/admin/loja/produtos/{id}/up")
    ProdutoResponseDTO atualizarProdutos(@PathVariable Long id,
                                         @RequestBody ProdutoRequestDTO dto,
                                         @RequestHeader("Authorization") String token);

    @DeleteMapping("/admin/loja/produtos/{id}/deletar")
    void deletarProdutos(@PathVariable Long id,
                         @RequestHeader("Authorization") String token);

    @PostMapping("/admin/loja/produtos/{id}/adicionar-estoque")
    void adicionarEstoque(@PathVariable Long id,
                          @RequestParam Integer quantidade,
                          @RequestHeader("Authorization") String token);

    @PostMapping("/admin/loja/produtos/{id}/remover-estoque")
    void removerEstoque(@PathVariable Long id,
                        @RequestParam Integer quantidade,
                        @RequestHeader("Authorization") String token);


    @GetMapping("/admin/loja/produtos/pesquisar")
    List<ProdutoResponseDTO> pesquisarProdutos(
            @ModelAttribute ProdutoFiltro filtro,
            @RequestHeader("Authorization") String token);
}
