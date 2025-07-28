package com.bff_studio.alan_godoy.business.services.escolademusica;

import com.bff_studio.alan_godoy.business.dto.escolademusica.out.receita.ReceitaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaReceitaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final EscolaReceitaClient client;

    public ReceitaResponseDTO calcularReceita(LocalDate inicio, LocalDate fim, String token) {
        return client.calcularReceitaEscola(inicio, fim, token);
    }

    public long contarMensalidadesPagas(LocalDate inicio, LocalDate fim, String token) {
        return client.contarPagasEscola(inicio, fim, token);
    }

    public long contarMensalidadesAbertas(LocalDate inicio, LocalDate fim, String token) {
        return client.contarNaoPagaEscolas(inicio, fim, token);
    }

}

