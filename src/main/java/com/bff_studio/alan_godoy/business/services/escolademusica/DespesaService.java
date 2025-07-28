package com.bff_studio.alan_godoy.business.services.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.receita.DespesasRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.receita.DespesasResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaDespesaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final EscolaDespesaClient client;


    public DespesasResponseDTO criarDespesa(DespesasRequestDTO despesaDTO, String token) {
        return client.criarDespesa(despesaDTO, token);
    }

    public List<DespesasResponseDTO> listarTodas(String token) {
        return client.listarTodasDespesas(token);
    }

    public List<DespesasResponseDTO> listarPorPeriodo(LocalDate inicio, LocalDate fim, String token) {
        return client.listarDespesasPorPeriodo(inicio, fim, token);
    }

    public List<DespesasResponseDTO> listarPorCategoria(Long categoriaId, String token) {
        return client.listarDespesasPorCategoria(categoriaId, token);
    }

    public List<DespesasResponseDTO> listarPorCategoriaEPeriodo(Long categoriaId,
                                                                LocalDate inicio,
                                                                LocalDate fim,
                                                                String token) {
        return client.listarDespesasPorCategoriaEPeriodo(categoriaId, inicio, fim, token);
    }

    public BigDecimal calcularTotalDespesasPeriodo(LocalDate inicio, LocalDate fim, String token) {
        return client.calcularTotalDespesasPeriodo(inicio, fim, token);
    }

    public BigDecimal calcularTotalPorCategoria(Long categoriaId,
                                                LocalDate inicio,
                                                LocalDate fim,
                                                String token) {
        return client.calcularTotalDespesasPorCategoria(categoriaId, inicio, fim, token);
    }


    public DespesasResponseDTO atualizarParcialmente(Long id,
                                                     Map<String,
                                                             Object> updates,
                                                     String token) {
        return client.atualizarDespesasParcialmente(id, updates, token);
    }


}



