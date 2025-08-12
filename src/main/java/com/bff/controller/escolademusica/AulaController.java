package com.bff.controller.escolademusica;


import com.bff.business.dto.escolademusica.in.aluno.AulaFilterDTO;
import com.bff.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.bff.business.services.escolademusica.AulaService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/admin/escola-musica/aula")
@RequiredArgsConstructor
@Tag(name = "Aulas", description = "Operações relacionadas a aulas")
public class AulaController {
    private final AulaService aulaService;

    @GetMapping("/aluno/{alunoId}")
    @Operation(summary = "Aulas por aluno", description = "Busca aulas de um aluno específico")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<AulaResponseDTO>> buscarPorAluno(@PathVariable Long alunoId,
                                                               @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasPorAluno(alunoId, token));
    }

    @GetMapping("/proximas/{alunoId}")
    @Operation(summary = "Busca as próximas aulas de um aluno",
            description = "Retorna aulas existentes e cria aulas recorrentes futuras")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas encontradas"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
    })
    public ResponseEntity<List<AulaResponseDTO>> buscarProximasAulas(
            @PathVariable Long alunoId,
            @RequestParam(defaultValue = "4") int semanas,
            @RequestHeader(name = "Authorization", required = false) String token) {

        List<AulaResponseDTO> aulas = aulaService.buscarProximasAulas(alunoId, semanas, token);
        return ResponseEntity.ok(aulas);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<AulaResponseDTO>> buscarTodasAulas(@RequestHeader(name = "Authorization", required = false) String token) {
        List<AulaResponseDTO> aulas = aulaService.buscarTodasAulas(token);
        return ResponseEntity.ok(aulas);
    }

    @GetMapping("/{id}")
    public ResponseEntity <AulaResponseDTO> buscarAulasPorId(@PathVariable Long id, @RequestHeader(name = "Authorization", required = false) String token) {
        AulaResponseDTO aula = aulaService.buscarAulaPorId(id, token);
        return ResponseEntity.ok(aula);
    }

    @GetMapping("/hoje")
    @Operation(summary = "Aulas de hoje", description = "Busca aulas agendadas para hoje")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AulaResponseDTO>> buscarAulasHoje(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasHoje(token));
    }

    @GetMapping("/semana")
    @Operation(summary = "Aulas da semana", description = "Busca aulas agendadas para esta semana")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AulaResponseDTO>> buscarAulasEstaSemana(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasEstaSemana(token));
    }

    @GetMapping("/mes")
    @Operation(summary = "Aulas do mês", description = "Busca aulas agendadas para este mês")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AulaResponseDTO>> buscarAulasEsteMes(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasEsteMes(token));
    }

    @GetMapping("/dia/{diaSemana}")
    @Operation(summary = "Aulas por dia da semana", description = "Busca aulas agendadas para um dia específico da semana")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "400", description = "Dia da semana inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AulaResponseDTO>> buscarPorDiaSemana(@PathVariable DayOfWeek diaSemana,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasPorDiaSemana(diaSemana, token));
    }

    @GetMapping("/filtro")
    @Operation(summary = "Aulas com filtro", description = "Busca aulas aplicando filtros específicos")
    @ApiResponse(responseCode = "200", description = "Aulas encontradas com sucesso")
    @ApiResponse(responseCode = "400", description = "Filtros inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AulaResponseDTO>> buscarComFiltro(@RequestBody AulaFilterDTO filtro,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(aulaService.buscarAulasComFiltro(filtro, token));
    }
}

