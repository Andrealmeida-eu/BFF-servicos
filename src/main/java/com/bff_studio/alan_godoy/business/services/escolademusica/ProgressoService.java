package com.bff_studio.alan_godoy.business.services.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusTopico;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoAlunoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoDetalhadoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoResumoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoTopicoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaAlunoClient;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaProgressoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressoService {

    private final EscolaProgressoClient client;
    private final EscolaAlunoClient alunoClient;


    // ========== MÉTODOS PRINCIPAIS ========== //


    public ProgressoTopicoResponseDTO iniciarTopico(Long alunoId, Long topicoId, String token) {
        return client.iniciarTopico(alunoId, topicoId, token);
    }


    public ProgressoTopicoResponseDTO concluirTopico(Long topicoId, String token) {
        return client.concluirTopico(topicoId, token);
    }

    public List<ProgressoDetalhadoResponseDTO.ProgressoDisciplinaDTO> buscarProximasDisciplinas(Long alunoId,
                                                                                                String token) {
        return client.getProximasDisciplinas(alunoId, token);
    }

    public List<ProgressoTopicoResponseDTO> buscarProximosTopicos(Long alunoId, String token) {
        return client.getProximosTopicos(alunoId, token);
    }


    // ========== MÉTODOS DE CONSULTA ========== //

    /**
     * Busca todas as progressões de um aluno (pode retornar lista vazia se não houver)
     */
    public List<ProgressoAlunoResponseDTO> buscarTodasProgressoesAluno(Long alunoId, String token) {
        return alunoClient.getProgressao(alunoId, token);
    }


    // Método para atualizar progresso
    public void atualizarProgresso(StatusTopico progresso, String token) {
        client.atualizarProgresso(progresso, token);
    }


    /**
     * Obtém o resumo do progresso atual do aluno
     */
    public ProgressoResumoResponseDTO obterResumoProgresso(Long alunoId, String token) {
        return client.getResumoAluno(alunoId, token);
    }


}

