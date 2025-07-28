package com.bff_studio.alan_godoy.business.services.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.receita.CategoriaDespesasRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.receita.CategoriaDespesasResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaCategoriaDespesaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoriaDespesasService {

    private final EscolaCategoriaDespesaClient client;



    public CategoriaDespesasResponseDTO criarCategoriaDespesa(CategoriaDespesasRequestDTO categoriaDTO, String token) {
        return client.criarCategoriaDespesas(categoriaDTO, token);
    }


    public CategoriaDespesasResponseDTO atualizarCategoriaDespesa(Long id,
                                                           CategoriaDespesasRequestDTO categoriaDTO,
                                                           String token) {
        return client.atualizarCategoriaDespesa(id, categoriaDTO, token);
    }

    public List<CategoriaDespesasResponseDTO> listarTodasCategoriaDespesa(String token) {
        return client.listarTodasCatDespesas(token);
    }

    public CategoriaDespesasResponseDTO buscarCatDespesaPorId(Long id, String token) {
        return client.buscarCatDespesaPorId(id, token);
    }


    public CategoriaDespesasResponseDTO atualizarCatDespesaParcialmente(Long id, Map<String, Object> updates, String token) {
        return client.atualizarParcialmenteCatDespesa(id, updates, token);
    }


    public void deletarCategoriaDespesa(Long id, String token) {
      client.deletarCatDespesa(id, token);
    }

}
