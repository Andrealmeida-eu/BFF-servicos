package com.bff.business.services.escolademusica;

import com.bff.business.dto.escolademusica.in.RelatorioAulaRequestDTO;
import com.bff.business.dto.escolademusica.out.RelatorioAulaResponseDTO;
import com.bff.infra.Client.EscolaClient.EscolaRelatorioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RelatorioAulaService {


    private final EscolaRelatorioClient client;


    public RelatorioAulaResponseDTO criarRelatorio(RelatorioAulaRequestDTO dto, String token) {
        return client.criarRelatorio(dto, token);
    }


    public List<RelatorioAulaResponseDTO> listarRelatorios(
            Long professorId, Long alunoId, LocalDate dataInicio, LocalDate dataFim, String token) {
        return client.listarRelatorios(professorId, alunoId, dataInicio, dataFim, token);
    }


    public RelatorioAulaResponseDTO atualizarParcialmente(Long id,
                                                          Map<String,
                                                                  Object> updates,
                                                          String token) {
        return client.atualizarRelatorioParcialmente(id, updates, token);
    }


}
