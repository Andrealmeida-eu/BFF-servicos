package com.bff_studio.alan_godoy.business.services.servicosmusicais;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.ServicoMusicalResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.ServicoMusicalResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient.ServicosMusicaisServicoMusicalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ServicoMusicalService {

    private final ServicosMusicaisServicoMusicalClient client;


    public List<ServicoMusicalResponseDTO> listarTodos(String token) {
        return client.listarTodosServicos(token);
    }

    public ServicoMusicalResponseDTO buscarPorId(Long id, String token) {
        return client.buscarServicosPorId(id, token);
    }

    public ServicoMusicalResponseDTO salvar(ServicoMusicalResquestDTO dto, String token) {

        return client.criarServicos(dto, token);
    }

    public void deletar(Long id, String token) {
        client.deletarServicos(id, token);
    }


    public CategoriaServicoResponseDTO atualizarParcialmente(Long id, Map<String, Object> updates, String token) {
        return client.atualizarParcialmenteCategoriaServico(id, updates, token);
    }
}
