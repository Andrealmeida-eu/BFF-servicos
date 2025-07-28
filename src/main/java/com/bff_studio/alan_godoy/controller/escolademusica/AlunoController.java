package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.AlunoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AlunoResponseDTO;

import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoAlunoResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.AlunoService;
import com.bff_studio.alan_godoy.business.services.escolademusica.ProgressoService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/escola-musica/alunos")
@Tag(name = "Alunos", description = "Operações relacionadas a alunos")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class AlunoController {


    private final AlunoService alunoService;
    private final ProgressoService progressoService;


    @PostMapping
    @Operation(summary = "Cadastrar aluno", description = "Cria um novo registro de aluno")
    @ApiResponse(responseCode = "200", description = "Aluno cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno(@RequestBody AlunoRequestDTO alunoDTO,
                                                           @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(alunoService.cadastrarAluno(alunoDTO, token));
    }

    @GetMapping("/{id}/progresso")
    @Operation(summary = "Progresso do aluno", description = "Obtém o progresso de um aluno específico")
    @ApiResponse(responseCode = "200", description = "Progresso retornado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<ProgressoAlunoResponseDTO>> getProgressao(@PathVariable Long id,
                                                                         @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(progressoService.buscarTodasProgressoesAluno(id, token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> BuscarAlunoPorId(@PathVariable @Valid Long id,
                                                             @RequestHeader(name = "Authorization", required = false) String token) {
        AlunoResponseDTO response = alunoService.buscarPorId(id, token);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de um aluno")
    @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<AlunoResponseDTO> atualizarAlunoParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(alunoService.atualizarParcialmente(id, updates, token));

    }

    @GetMapping
    @Operation(summary = "Listar alunos", description = "Recupera todos os alunos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<AlunoResponseDTO>> listarTodosAlunos(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(alunoService.listarTodos(token));
    }

    @DeleteMapping("{id}")
    public void removerAluno(@PathVariable Long id,
                             @RequestHeader(name = "Authorization", required = false) String token) {
        alunoService.deletarAluno(id, token);

    }
}
