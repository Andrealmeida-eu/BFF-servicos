package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.RelatorioAulaRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.RelatorioAulaResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.RelatorioAulaService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/escola-musica/relatorios")
@Tag(name = "Relatórios", description = "Operações relacionadas a relatórios de aula")
public class RelatorioAulaController {


    private final RelatorioAulaService relatorioService;


    @PostMapping
    @Operation(summary = "Criar relatório", description = "Cria um novo relatório de aula")
    @ApiResponse(responseCode = "201", description = "Relatório criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<RelatorioAulaResponseDTO> criarRelatorio(
             @RequestBody RelatorioAulaRequestDTO dto,
            @RequestHeader(name = "Authorization", required = false) String token) {

        RelatorioAulaResponseDTO response = relatorioService.criarRelatorio(dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Listar relatórios", description = "Lista relatórios com filtros opcionais")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Filtros inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<RelatorioAulaResponseDTO>> listarRelatorios(
            @RequestParam(required = false) Long professorId,
            @RequestParam(required = false) Long alunoId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
           @RequestHeader(name = "Authorization", required = false) String token) {

        List<RelatorioAulaResponseDTO> relatorios = relatorioService.listarRelatorios(
                professorId, alunoId, dataInicio, dataFim, token);

        return ResponseEntity.ok(relatorios);
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente um relatório")
    @ApiResponse(responseCode = "200", description = "Relatório atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Relatório não encontrado")
    public ResponseEntity<RelatorioAulaResponseDTO> atualizarRelatorioParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String,
                    Object> updates,
           @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(relatorioService.atualizarParcialmente(id, updates, token));
    }

   /*@GetMapping("/{id}")
    public ResponseEntity<RelatorioAulaDTO> buscarPorAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(relatorioAulaRepository.findByAlunoId(alunoId));
    }*/
}
