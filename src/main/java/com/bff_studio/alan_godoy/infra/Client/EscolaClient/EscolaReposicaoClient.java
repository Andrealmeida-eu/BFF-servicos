package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusReposicao;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.ReposicaoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.HistoricoStatusReposicaoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.ReposicaoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import com.bff_studio.alan_godoy.infra.Client.config.HorarioDisponivelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "escola-reposicao-client", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaReposicaoClient {

    @PostMapping("/admin/escola-musica/reposicao/marcar")
    AulaResponseDTO marcarReposicao(@RequestBody ReposicaoRequestDTO reposicaoDTO,
                                                           @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/dia")
    List<ReposicaoResponseDTO> listarPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/mes")
    List<ReposicaoResponseDTO> listarPorMes(
            @RequestParam int ano,
            @RequestParam int mes,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/proximas")
    List<ReposicaoResponseDTO> listarProximas(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/all")
   List<ReposicaoResponseDTO> listarTodas (@RequestHeader("Authorization") String token);


    @PutMapping("/admin/escola-musica/reposicao/{id}/status")
    void atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusReposicao novoStatus,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao//{id}")
    ReposicaoRequestDTO getReposicao(@PathVariable Long id,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/{id}/historico")
    List<HistoricoStatusReposicaoResponseDTO> getHistorico(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/{id}/historico/periodo")
    List<HistoricoStatusReposicaoResponseDTO> getHistoricoPorPeriodo(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/aluno/{alunoId}")
    List<ReposicaoResponseDTO> getReposicoesPorAluno(
            @PathVariable Long alunoId,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/professor/{professorId}")
    List<ReposicaoResponseDTO> getReposicoesPorProfessor(
            @PathVariable Long professorId,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/realizadas")
    List<ReposicaoResponseDTO> getReposicoesRealizadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/reposicao/disponibilidade/{professorId}")
    List<HorarioDisponivelDTO> getHorariosDisponiveis(
            @PathVariable Long professorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader(name = "Authorization") String token);

}
