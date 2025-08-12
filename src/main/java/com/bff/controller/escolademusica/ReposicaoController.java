package com.bff.controller.escolademusica;


import com.bff.business.dto.escolademusica.enums.StatusReposicao;
import com.bff.business.dto.escolademusica.in.ReposicaoRequestDTO;
import com.bff.business.dto.escolademusica.out.HistoricoStatusReposicaoResponseDTO;
import com.bff.business.dto.escolademusica.out.ReposicaoResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.bff.business.services.escolademusica.AulaService;
import com.bff.infra.Client.config.HorarioDisponivelDTO;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/admin/escola-musica/reposicao")
@Tag(name = "Reposições", description = "Operações relacionadas a aulas de reposição")
public class ReposicaoController {

    private final AulaService aulaService;


    @PostMapping("/marcar")
    @Operation(summary = "Marcar reposição", description = "Agenda uma aula de reposição")
    @ApiResponse(responseCode = "200", description = "Reposição marcada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<AulaResponseDTO> marcarReposicao(@RequestBody ReposicaoRequestDTO reposicaoDTO,
                                                          @RequestHeader(name = "Authorization", required = false) String token) {
        AulaResponseDTO aulaReposicaoDTO = aulaService.marcarReposicao(reposicaoDTO, token);
        return ResponseEntity.ok(aulaReposicaoDTO);

    }

    @GetMapping("/dia")
    @Operation(summary = "Reposições por dia", description = "Lista as reposições agendadas para um dia específico")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Data inválida")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ReposicaoResponseDTO>> listarPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
           @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.listarReposicoesDoDia(data, token);
        return ResponseEntity.ok(reposicoes);
    }

    @GetMapping("/mes")
    @Operation(summary = "Reposições por mês", description = "Lista as reposições agendadas para um mês específico")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Mês/ano inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ReposicaoResponseDTO>> listarPorMes(
            @RequestParam int ano,
            @RequestParam int mes,
           @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.listarReposicoesDoMes(ano, mes, token);
        return ResponseEntity.ok(reposicoes);
    }

    @GetMapping("/proximas")
    @Operation(summary = "Próximas reposições", description = "Lista as próximas reposições agendadas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ReposicaoResponseDTO>> listarProximas(@RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.listarReposicoesProximas(token);
        return ResponseEntity.ok(reposicoes);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Atualizar status", description = "Atualiza o status de uma reposição")
    @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Status inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Reposição não encontrada")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusReposicao novoStatus,
           @RequestHeader(name = "Authorization", required = false) String token) {
        aulaService.alterarStatusReposicao(id, novoStatus, token);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reposição", description = "Recupera os dados de uma reposição específica")
    @ApiResponse(responseCode = "200", description = "Reposição encontrada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Reposição não encontrada")
    public ResponseEntity<ReposicaoRequestDTO> getReposicao(@PathVariable Long id,
                                                           @RequestHeader(name = "Authorization", required = false) String token) {
        ReposicaoRequestDTO reposicao = aulaService.buscarPorId(id, token);
        return ResponseEntity.ok(reposicao);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReposicaoResponseDTO>> listarTodas( @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.getAllRepositions(token);
        return ResponseEntity.ok(reposicoes);
    }


    @GetMapping("/{id}/historico")
    @Operation(summary = "Histórico de status", description = "Recupera o histórico de status de uma reposição")
    @ApiResponse(responseCode = "200", description = "Histórico retornado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Reposição não encontrada")
    public ResponseEntity<List<HistoricoStatusReposicaoResponseDTO>> getHistorico(
            @PathVariable Long id,
           @RequestHeader(name = "Authorization", required = false) String token) {
        List<HistoricoStatusReposicaoResponseDTO> historico = aulaService.buscarHistoricoPorReposicaoId(id, token);
        return ResponseEntity.ok(historico);
    }


    @GetMapping("/aluno/{alunoId}")
    @Operation(summary = "Reposições por aluno", description = "Lista as reposições de um aluno específico")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<ReposicaoResponseDTO>> getReposicoesPorAluno(
            @PathVariable Long alunoId,
            @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.buscarPorAlunoId(alunoId, token);
        return ResponseEntity.ok(reposicoes);
    }



    @GetMapping("/realizadas")
    @Operation(summary = "Reposições realizadas", description = "Lista as reposições realizadas em um período")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ReposicaoResponseDTO>> getReposicoesRealizadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
           @RequestHeader(name = "Authorization", required = false) String token) {
        List<ReposicaoResponseDTO> reposicoes = aulaService.buscarRealizadasPorPeriodo(inicio, fim, token);
        return ResponseEntity.ok(reposicoes);
    }

        @GetMapping("/disponibilidade/{professorId}")
        public ResponseEntity<List<HorarioDisponivelDTO>> getHorariosDisponiveis(
                @PathVariable Long professorId,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
                @RequestHeader(name = "Authorization", required = false) String token) {

            List<HorarioDisponivelDTO> horarios = aulaService.getHorariosDisponiveis( professorId, inicio, fim, token);
            return ResponseEntity.ok(horarios);
        }


}

