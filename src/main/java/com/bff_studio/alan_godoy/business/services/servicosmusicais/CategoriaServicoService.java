package com.bff_studio.alan_godoy.business.services.servicosmusicais;

import com.bff_studio.alan_godoy.business.dto.servicosmusicais.in.CategoriaServicoResquestDTO;
import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient.ServicosMusicaisServicoMusicalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServicoService {

    private final ServicosMusicaisServicoMusicalClient client;


    public CategoriaServicoResponseDTO criar(CategoriaServicoResquestDTO dto, String token) {
        return client.criarCategoriaServico(dto, token);
    }

    public List<CategoriaServicoResponseDTO> listarTodasAtivas(String token) {
        return client.listarCategoriaServicoAtivas(token);
    }


    public CategoriaServicoResponseDTO buscarPorId(Long id, String token) {
        return client.buscarCatPorId(id, token);
    }


    public void inativar(Long id, String token) {
        client.inativar(id, token);
    }

    public CategoriaServicoResponseDTO atualizar(Long id, CategoriaServicoResquestDTO dto, String token) {

        return client.atualizarServicoCategoria(id, dto, token);
    }
}
