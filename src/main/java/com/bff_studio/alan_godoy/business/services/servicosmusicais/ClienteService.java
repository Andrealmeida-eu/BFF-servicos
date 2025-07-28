package com.bff_studio.alan_godoy.business.services.servicosmusicais;

import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.ClienteResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.ClienteResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient.ServicosMusicaisClienteClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ServicosMusicaisClienteClient client;

    /**
     * Cria um novo cliente no sistema
     *
     * @param dto DTO contendo os dados do cliente
     * @return ClienteDTO com os dados do cliente criado
     */

    public ClienteResponseDTO criarCliente(ClienteResquestDTO dto, String token) {
        return client.criarCliente(dto, token);
    }


    /**
     * Lista todos os clientes cadastrados
     *
     * @return Lista de ClienteDTO
     */

    public List<ClienteResponseDTO> listarTodos(String token) {
        return client.listarTodosClientes(token);
    }


    /**
     * Atualiza os dados de um cliente existente
     *
     * @param id  ID do cliente a ser atualizado
     * @param dto DTO com os novos dados
     * @return ClienteDTO atualizado
     */
    public ClienteResponseDTO atualizarCliente(Long id, ClienteResquestDTO dto, String token) {
        return client.atualizar(id, dto, token);
    }

    /**
     * Remove um cliente do sistema
     *
     * @param id ID do cliente a ser removido
     */

    public void deletar(Long id, String token) {
        client.deletarCliente(id, token);
    }


    public ClienteResponseDTO atualizarParcialmente(Long id, Map<String, Object> updates, String token) {
        return client.atualizarClienteParcialmente(id, updates, token);
    }
}



