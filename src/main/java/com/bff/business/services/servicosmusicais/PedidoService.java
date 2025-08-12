package com.bff.business.services.servicosmusicais;


import com.bff.business.dto.servicosmusicais.enums.StatusPedido;
import com.bff.business.dto.servicosmusicais.in.PedidoResquestDTO;
import com.bff.business.dto.servicosmusicais.out.PedidoResponseDTO;
import com.bff.infra.Client.servicosMusicaisClient.ServicosMusicaisPedidoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PedidoService {


    private final ServicosMusicaisPedidoClient client;

    public PedidoResponseDTO criarPedido(PedidoResquestDTO dto, String token) {
        return client.criarPedido(dto, token);
    }

    public PedidoResponseDTO atualizarStatus(Long id, StatusPedido status, String token) {
        return client.atualizarStatusPedido(id, status, token);
    }

    public List<PedidoResponseDTO> listarTodos(String token) {
        return client.listarTodosPedidos(token);
    }

    public void deletar(Long id, String token) {
        client.deletarPedido(id, token);
    }


    public PedidoResponseDTO atualizarParcialmente(Long id,
                                                   Map<String,
                                                           Object> updates,
                                                   String token) {
        return client.atualizarPedidoParcialmente(id, updates, token);
    }


}
