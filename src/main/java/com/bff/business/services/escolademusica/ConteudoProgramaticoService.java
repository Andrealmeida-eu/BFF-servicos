package com.bff.business.services.escolademusica;


import com.bff.business.dto.escolademusica.in.conteudo.ConteudoProgramaticoRequestDTO;
import com.bff.business.dto.escolademusica.in.conteudo.DisciplinaRequestDTO;
import com.bff.business.dto.escolademusica.in.conteudo.TopicoRequestDTO;
import com.bff.business.dto.escolademusica.out.conteudo.ConteudoProgramaticoResponseDTO;
import com.bff.business.dto.escolademusica.out.conteudo.DisciplinaResponseDTO;
import com.bff.business.dto.escolademusica.out.conteudo.TopicoResponseDTO;
import com.bff.infra.Client.EscolaClient.EscolaConteudoProgramaticoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConteudoProgramaticoService {

    private final EscolaConteudoProgramaticoClient client;

    // ========== OPERAÇÕES PRINCIPAIS ========== //

    /**
     * Cria um novo conteúdo programático para um instrumento
     */
    public ConteudoProgramaticoResponseDTO criarConteudoCompleto(ConteudoProgramaticoRequestDTO dto, String token) {
        // Extrai o instrumentoId do DTO (não precisa recebê-lo separadamente)
        Long instrumentoId = dto.getInstrumentoId();
        // Chama o Client (que deve estar alinhado com o Controller original)
        return client.criarConteudoCompleto(dto, token);
    }

    /**
     * Atualiza todo o conteúdo programático de um instrumento
     */
    public ConteudoProgramaticoResponseDTO atualizarConteudoCompleto(Long instrumentoId,
                                                               ConteudoProgramaticoRequestDTO dto,
                                                               String token) {

        return client.atualizarConteudoCompleto(instrumentoId, dto, token);
    }

    // ========== OPERAÇÕES DE DISCIPLINAS ========== //

    /**
     * Adiciona uma nova disciplina ao conteúdo existente
     */
    public DisciplinaResponseDTO adicionarDisciplina(DisciplinaRequestDTO dto, String token) {
        return client.adicionarDisciplina(dto, token);
    }


    /**
     * Atualiza uma disciplina existente
     */
    public DisciplinaResponseDTO atualizarDisciplina(Long disciplinaId,
                                                     DisciplinaRequestDTO disciplinaDTO,
                                                     String token) {
        return client.atualizarDisciplina(disciplinaId, disciplinaDTO, token);
    }

    public void inativarDisciplina(Long disciplinaId,
                                  String token) {
        client.excluirDisciplina(disciplinaId, token);
    }

    public List<DisciplinaResponseDTO> listarTodas(String token) {
        return client.listarDisciplinas(token);
    }

    // ========== OPERAÇÕES DE TÓPICOS ========== //

    /**
     * Adiciona um novo tópico a uma disciplina
     */
    public TopicoResponseDTO adicionarTopico(Long disciplinaId, TopicoRequestDTO topicoDTO, String token) {
        return client.adicionarTopico(topicoDTO, token);
    }

    /**
     * Atualiza um tópico existente
     */
    public TopicoResponseDTO atualizarTopico(Long topicoId, TopicoRequestDTO topicoDTO, String token) {
        return client.atualizarTopico(topicoId, topicoDTO, token);
    }

    public void inativarTopico(Long id, String token) {
        client.excluirTopico(id, token);
    }

    public List<TopicoResponseDTO> listarPorDisciplina(Long disciplinaId, String token) {
        return client.listarTopicosPorDisciplina(disciplinaId, token);
    }

    // ========== CONSULTAS ========== //

    /**
     * Busca o conteúdo completo de um instrumento
     */
    public ConteudoProgramaticoResponseDTO buscarConteudoCompleto(Long instrumentoId, String token) {
        return client.buscarConteudoCompleto(instrumentoId, token);
    }

    /**
     * Lista todos os conteúdos programáticos (para administração)
     */
    public List<ConteudoProgramaticoResponseDTO> listarTodosConteudos(String token) {
        return client.listarTodosConteudos(token);
    }



    public void inativarConteudo(Long conteudoId, String token) {
     client.removerConteudoProgramatico(conteudoId, token);
    }


    public ConteudoProgramaticoResponseDTO atualizarParcialmente(Long id,
                                                                 Map<String, Object> updates,
                                                                 String token) {
        return client.atualizarParcialmenteConteudoProg(id, updates, token);
    }


}