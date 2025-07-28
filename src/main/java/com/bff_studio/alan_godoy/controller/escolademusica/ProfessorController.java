package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.ProfessorRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.ProfessorResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.ProfessorService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/admin/escola-musica/professores")
@Tag(name = "Professores", description = "Operações relacionadas a professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;


    @PostMapping
    @Operation(summary = "Cadastrar professor", description = "Registra um novo professor")
    @ApiResponse(responseCode = "201", description = "Professor cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<ProfessorResponseDTO> cadastrarProfessor(
            @RequestBody ProfessorRequestDTO professorDTO,
          @RequestHeader(name = "Authorization", required = false) String token) {

        ProfessorResponseDTO professorSalvo = professorService.cadastrarProfessor(professorDTO, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
    }

    @GetMapping
    @Operation(summary = "Listar professores", description = "Lista todos os professores cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ProfessorResponseDTO>> listarTodosProfessores(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(professorService.listarTodos(token));
    }

    @PatchMapping("/categoria/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de um professor")
    @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessorParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(professorService.atualizarParcialmente(id, updates, token));
    }
}


