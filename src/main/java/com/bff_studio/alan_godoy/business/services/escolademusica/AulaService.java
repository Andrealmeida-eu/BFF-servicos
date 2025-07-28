package com.bff_studio.alan_godoy.business.services.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusReposicao;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.ReposicaoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.AulaFilterDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.HistoricoStatusReposicaoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.ReposicaoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaAulaClient;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaReposicaoClient;
import com.bff_studio.alan_godoy.infra.Client.config.HorarioDisponivelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final EscolaAulaClient aulaClient;
    private final EscolaReposicaoClient reposicaoClient;

    public List<AulaResponseDTO> buscarTodasAulas(String token) {
        return aulaClient.buscarTodasAulas(token);
    }

    public AulaResponseDTO buscarAulaPorId(Long id, String token) {

        return aulaClient.buscarAulasPorId(id, token);
    }

    public List<AulaResponseDTO> buscarAulasPorAluno(Long alunoId, String token) {
        return aulaClient.buscarPorAluno(alunoId, token);
    }


    public List<AulaResponseDTO> buscarProximasAulas(Long alunoId, int semanas, String token) {
        return aulaClient.buscarProximasAulas(alunoId, semanas, token);
    }


    public List<AulaResponseDTO> buscarAulasHoje(String token) {
        return aulaClient.buscarAulasHoje(token);
    }

    public List<AulaResponseDTO> buscarAulasEstaSemana(String token) {
        return aulaClient.buscarAulasEstaSemana(token);
    }

    public List<AulaResponseDTO> buscarAulasEsteMes(String token) {
        return aulaClient.buscarAulasEsteMes(token);
    }

    public List<AulaResponseDTO> buscarAulasPorDiaSemana(DayOfWeek diaSemana, String token) {
        return aulaClient.buscarPorDiaSemana(diaSemana, token);
    }

    public List<AulaResponseDTO> buscarAulasComFiltro(AulaFilterDTO filtro, String token) {
        return aulaClient.buscarComFiltro(filtro, token);
    }


    public AulaResponseDTO marcarReposicao(ReposicaoRequestDTO reposicaoDTO,
                                           String token) {
        return reposicaoClient.marcarReposicao(reposicaoDTO, token);
    }

    public List<ReposicaoResponseDTO> listarReposicoesDoDia(LocalDate data, String token) {
        return reposicaoClient.listarPorDia(data, token);
    }

    public List<ReposicaoResponseDTO> listarReposicoesDoMes(int ano, int mes, String token) {
        return reposicaoClient.listarPorMes(ano, mes, token);
    }

    public List<ReposicaoResponseDTO> listarReposicoesProximas(String token) {
        return reposicaoClient.listarProximas(token);
    }

    public void alterarStatusReposicao(Long reposicaoId, StatusReposicao novoStatus, String token) {
        reposicaoClient.atualizarStatus(reposicaoId, novoStatus, token);
    }


    public ReposicaoRequestDTO buscarPorId(Long id, String token) {
        return reposicaoClient.getReposicao(id, token);
    }

    public List<HistoricoStatusReposicaoResponseDTO> buscarHistoricoPorReposicaoId(Long id,
                                                                                   String token) {

        return reposicaoClient.getHistorico(id, token);
    }


    public List<ReposicaoResponseDTO> buscarPorAlunoId(Long alunoId, String token) {
        return reposicaoClient.getReposicoesPorAluno(alunoId, token);
    }


    public List<ReposicaoResponseDTO> buscarRealizadasPorPeriodo(LocalDateTime inicio,
                                                                 LocalDateTime fim,
                                                                 String token) {

        return reposicaoClient.getReposicoesRealizadasPorPeriodo(inicio, fim, token);
    }

    public List<HorarioDisponivelDTO> getHorariosDisponiveis(Long professorId, LocalDate dataInicio, LocalDate dataFim, String token) {

        return reposicaoClient.getHorariosDisponiveis(professorId, dataInicio, dataFim, token);
    }

    public List<ReposicaoResponseDTO> getAllRepositions(String token) {

        return reposicaoClient.listarTodas(token);
    }


}

