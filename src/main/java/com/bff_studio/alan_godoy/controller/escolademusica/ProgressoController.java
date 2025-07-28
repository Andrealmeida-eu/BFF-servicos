package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.in.progresso.ProgressoTopicoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoDetalhadoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoResumoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoTopicoResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.ProgressoService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/escola-musica/progresso")
@Tag(name = "Progresso", description = "Operações relacionadas ao progresso dos alunos")
public class ProgressoController {


    private final ProgressoService progressoService;


    @PatchMapping("/topicos/{topicoId}/concluir")
    @Operation(summary = "Concluir tópico", description = "Marca um tópico como concluído")
    @ApiResponse(responseCode = "200", description = "Tópico concluído com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Tópico não encontrado")
    public ResponseEntity<ProgressoTopicoResponseDTO> concluirnTopico(@PathVariable Long topicoId,
                                                                     @RequestHeader(name = "Authorization", required = false) String token) {
        ProgressoTopicoResponseDTO progresso = progressoService.concluirTopico(topicoId, token);
        return ResponseEntity.ok(progresso);
    }

    @PatchMapping("/alunos/{alunoId}/topicos/{topicoId}/iniciar")
    @Operation(summary = "Iniciar tópico", description = "Marca um tópico como iniciado")
    @ApiResponse(responseCode = "200", description = "Tópico iniciado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno ou tópico não encontrado")
    public ResponseEntity<ProgressoTopicoResponseDTO> iniciarTopico(@PathVariable Long alunoId,
                                                                    @PathVariable Long topicoId,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        ProgressoTopicoResponseDTO response = progressoService.iniciarTopico(alunoId, topicoId, token);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Atualizar progresso", description = "Atualiza o status de progresso de um tópico")
    @ApiResponse(responseCode = "200", description = "Progresso atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Status inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<Void> atualizarProgresso(@RequestBody ProgressoTopicoRequestDTO progressoDTO,
                                                  @RequestHeader(name = "Authorization", required = false) String token) {
        progressoService.atualizarProgresso(progressoDTO.getStatus(), token);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/aluno/{alunoId}/resumo")
    @Operation(summary = "Resumo do progresso", description = "Obtém um resumo do progresso do aluno")
    @ApiResponse(responseCode = "200", description = "Resumo retornado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<ProgressoResumoResponseDTO> getResumoAluno( @PathVariable Long alunoId,
                                                                     @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(
                progressoService.obterResumoProgresso(alunoId, token)
        );
    }

    @GetMapping("/aluno/{alunoId}/proximos-topicos")
    @Operation(summary = "Próximos tópicos", description = "Lista os próximos tópicos recomendados para o aluno")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<ProgressoTopicoResponseDTO>> getProximosTopicos( @PathVariable Long alunoId,
                                                                               @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(
                progressoService.buscarProximosTopicos(alunoId, token)
        );
    }

    @GetMapping("/aluno/{alunoId}/proximas-disciplinas")
    @Operation(summary = "Próximas disciplinas", description = "Lista as próximas disciplinas recomendadas para o aluno")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<ProgressoDetalhadoResponseDTO.ProgressoDisciplinaDTO>> getProximasDisciplinas(
            @PathVariable Long alunoId,
           @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(
                progressoService.buscarProximasDisciplinas(alunoId, token)
        );
    }

}
