package com.bff.business.services.loja;


import com.bff.business.dto.loja.Specification.ProdutoFiltro;
import com.bff.business.dto.loja.in.ProdutoRequestDTO;
import com.bff.business.dto.loja.out.ProdutoResponseDTO;
import com.bff.infra.Client.lojaClient.LojaProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final LojaProdutoClient produtoClient;

    /**
     * Lista todos os produtos ativos
     * @return Lista de ProdutoDTO
     */

    public List<ProdutoResponseDTO> listarTodos(String token) {
        return produtoClient.listarTodosProdutos(token);
    }



    public ProdutoResponseDTO buscarPorId(Long id, String token) {
        return produtoClient.buscarProdutosPorId(id, token);
    }

    /**
     * Salva um novo produto ou atualiza um existente
     * @param dto DTO com os dados do produto
     * @return ProdutoDTO salvo
     */

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto, String token) {
       return produtoClient.salvarProdutos(dto, token);
    }

    /**
     * Realiza soft delete de um produto (inativa)
     * @param id ID do produto
     */

    public void deletar(Long id, String token) {
   produtoClient.deletarProdutos(id, token);
    }

    /**
     * Adiciona quantidade ao estoque de um produto
     * @param produtoId ID do produto
     * @param quantidade Quantidade a adicionar
     */

    public void adicionarEstoque(Long produtoId, Integer quantidade, String token) {
      produtoClient.adicionarEstoque(produtoId, quantidade, token);
    }

    /**
     * Remove quantidade do estoque de um produto
     * @param produtoId ID do produto
     * @param quantidade Quantidade a remover
     */

    public void removerEstoque(Long produtoId, Integer quantidade, String token) {
      produtoClient.removerEstoque(produtoId, quantidade, token);
    }

    /**
     * Atualiza os dados básicos de um produto
     * @param id ID do produto
     * @param produtoDTO DTO com os novos dados
     * @return ProdutoDTO atualizado
     */

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO produtoDTO, String token) {
      return produtoClient.atualizarProdutos(id, produtoDTO, token);
    }

    /**
     * Pesquisa produtos com base em filtros
     * @param filtro Objeto com os critérios de pesquisa
     * @return Lista de ProdutoDTO que atendem aos filtros
     */
    public List<ProdutoResponseDTO> pesquisarProdutos(ProdutoFiltro filtro, String token) {
      return produtoClient.pesquisarProdutos(filtro, token);
    }
}

