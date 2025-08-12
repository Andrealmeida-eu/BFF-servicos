package com.bff.controller.escolademusica;



import com.bff.business.dto.escolademusica.in.conteudo.ConteudoProgramaticoRequestDTO;
import com.bff.business.dto.escolademusica.in.conteudo.DisciplinaRequestDTO;
import com.bff.business.dto.escolademusica.in.conteudo.TopicoRequestDTO;
import com.bff.business.dto.escolademusica.out.conteudo.ConteudoProgramaticoResponseDTO;
import com.bff.business.dto.escolademusica.out.conteudo.DisciplinaResponseDTO;
import com.bff.business.dto.escolademusica.out.conteudo.TopicoResponseDTO;
import com.bff.business.services.escolademusica.ConteudoProgramaticoService;
import com.bff.infra.Client.config.SecurityConfig;
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
@RequestMapping("/admin/escola-musica/conteudo-programatico")
@RequiredArgsConstructor
@Tag(name = "Conteúdo Programático", description = "Operações relacionadas ao conteúdo programático")
public class ConteudoProgramaticoController {

 private final ConteudoProgramaticoService conteudoService;

    // ========== ENDPOINTS PRINCIPAIS ========== //

    @PostMapping
    @Operation(summary = "Criar conteúdo completo", description = "Cadastra um novo conteúdo programático completo")
    @ApiResponse(responseCode = "201", description = "Conteúdo criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<ConteudoProgramaticoResponseDTO> criarConteudoCompleto(
            @RequestBody ConteudoProgramaticoRequestDTO dto,  // instrumentoId está aqui
            @RequestHeader(name = "Authorization", required = false) String token      // Corrigi o typo "Authorization"
    ) {
        ConteudoProgramaticoResponseDTO response = conteudoService
                .criarConteudoCompleto(dto, token);  // Não passa instrumentoId separado
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{instrumentoId}")
    @Operation(summary = "Atualizar conteúdo completo", description = "Atualiza todo o conteúdo programático de um instrumento")
    @ApiResponse(responseCode = "200", description = "Conteúdo atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Instrumento não encontrado")
    public ResponseEntity<ConteudoProgramaticoResponseDTO> atualizarConteudoCompleto(
            @PathVariable Long instrumentoId,
            @RequestBody ConteudoProgramaticoRequestDTO dto,
          @RequestHeader(name = "Authorization", required = false) String token ) {
        ConteudoProgramaticoResponseDTO response = conteudoService.atualizarConteudoCompleto(instrumentoId, dto, token);
        return ResponseEntity.ok(response);
    }

    // ========== ENDPOINTS DE CONSULTA ========== //

    @GetMapping("/instrumento/{instrumentoId}")
    @Operation(summary = "Buscar conteúdo completo", description = "Recupera todo o conteúdo programático de um instrumento")
    @ApiResponse(responseCode = "200", description = "Conteúdo encontrado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Instrumento não encontrado")
    public ResponseEntity<ConteudoProgramaticoResponseDTO> buscarConteudoCompleto(
            @PathVariable Long instrumentoId,
          @RequestHeader(name = "Authorization", required = false) String token ) {
        ConteudoProgramaticoResponseDTO response = conteudoService.buscarConteudoCompleto(instrumentoId, token);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar conteúdos", description = "Lista todos os conteúdos programáticos")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<ConteudoProgramaticoResponseDTO>> listarTodosConteudos(@RequestHeader(name = "Authorization", required = false) String token ) {
        List<ConteudoProgramaticoResponseDTO> response = conteudoService.listarTodosConteudos(token);
        return ResponseEntity.ok(response);
    }

    // ========== ENDPOINTS DE DISCIPLINAS ========== //

    @PostMapping("/disciplinas")
    @Operation(summary = "Adicionar disciplina", description = "Adiciona uma nova disciplina ao conteúdo programático")
    @ApiResponse(responseCode = "201", description = "Disciplina criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<DisciplinaResponseDTO> adicionarDisciplina(
            @RequestBody DisciplinaRequestDTO dto,
          @RequestHeader(name = "Authorization", required = false) String token) {
        DisciplinaResponseDTO response = conteudoService.adicionarDisciplina(dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/disciplinas/{disciplinaId}")
    @Operation(summary = "Atualizar disciplina", description = "Atualiza os dados de uma disciplina")
    @ApiResponse(responseCode = "200", description = "Disciplina atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
    public ResponseEntity<DisciplinaResponseDTO> atualizarDisciplina(
            @PathVariable Long disciplinaId,
            @RequestBody  DisciplinaRequestDTO dto,
          @RequestHeader(name = "Authorization", required = false) String token) {
        DisciplinaResponseDTO response = conteudoService.atualizarDisciplina(disciplinaId, dto, token);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/disciplinas/{id}")
    @Operation(summary = "Excluir disciplina", description = "Remove uma disciplina do conteúdo programático")
    @ApiResponse(responseCode = "204", description = "Disciplina excluída com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
    public ResponseEntity<Void> excluirDisciplina(@PathVariable Long id,
                                                @RequestHeader(name = "Authorization", required = false) String token) {
        conteudoService.inativarDisciplina(id, token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disciplinas")
    @Operation(summary = "Listar disciplinas", description = "Lista todas as disciplinas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<List<DisciplinaResponseDTO>> listarDisciplinas(@RequestHeader(name = "Authorization", required = false) String token) {
        List<DisciplinaResponseDTO> disciplinas = conteudoService.listarTodas(token);
        return ResponseEntity.ok(disciplinas);
    }

    // ========== ENDPOINTS DE TÓPICOS ========== //

    @PostMapping("/topicos")
    @Operation(summary = "Adicionar tópico", description = "Adiciona um novo tópico a uma disciplina")
    @ApiResponse(responseCode = "201", description = "Tópico criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
    public ResponseEntity<TopicoResponseDTO> adicionarTopico(
            @RequestBody TopicoRequestDTO dto,
          @RequestHeader(name = "Authorization", required = false) String token) {
        TopicoResponseDTO response = conteudoService.adicionarTopico(dto.getDisciplinaId(), dto, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/topicos/{topicoId}")
    @Operation(summary = "Atualizar tópico", description = "Atualiza os dados de um tópico")
    @ApiResponse(responseCode = "200", description = "Tópico atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Tópico não encontrado")
    public ResponseEntity<TopicoResponseDTO> atualizarTopico(
            @PathVariable Long topicoId,
            @RequestBody  TopicoRequestDTO dto,
          @RequestHeader(name = "Authorization", required = false) String token) {
        TopicoResponseDTO response = conteudoService.atualizarTopico(topicoId, dto, token);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/topicos/{id}")
    @Operation(summary = "Excluir tópico", description = "Remove um tópico de uma disciplina")
    @ApiResponse(responseCode = "204", description = "Tópico excluído com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Tópico não encontrado")
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id,
                                            @RequestHeader(name = "Authorization", required = false) String token) {
        conteudoService.inativarTopico(id, token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disciplinas/{disciplinaId}/topicos")
    @Operation(summary = "Listar tópicos", description = "Lista todos os tópicos de uma disciplina")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
    public ResponseEntity<List<TopicoResponseDTO>> listarTopicosPorDisciplina(
            @PathVariable Long disciplinaId,
          @RequestHeader(name = "Authorization", required = false) String token) {
        List<TopicoResponseDTO> topicos = conteudoService.listarPorDisciplina(disciplinaId, token);
        return ResponseEntity.ok(topicos);
    }
    // ========== ENDPOINTS DE REMOÇÃO ========== //

    @DeleteMapping("/{instrumentoId}")
    @Operation(summary = "Remover conteúdo", description = "Remove todo o conteúdo programático de um instrumento")
    @ApiResponse(responseCode = "204", description = "Conteúdo removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Instrumento não encontrado")
    public ResponseEntity<Void> removerConteudoProgramatico(
            @PathVariable Long instrumentoId,
          @RequestHeader(name = "Authorization", required = false) String token) {
        conteudoService.inativarConteudo(instrumentoId, token);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente o conteúdo programático")
    @ApiResponse(responseCode = "200", description = "Conteúdo atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Conteúdo não encontrado")
    public ResponseEntity<ConteudoProgramaticoResponseDTO> atualizarParcialmenteConteudoProg(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(conteudoService.atualizarParcialmente(id, updates, token));

    }
}