package com.bff_studio.alan_godoy.controller.escolademusica;


import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import com.bff_studio.alan_godoy.business.services.escolademusica.InstrumentoService;
import com.bff_studio.alan_godoy.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/admin/escola-musica/instrumentos")
@Tag(name = "Instrumentos", description = "Operações administrativas relacionadas a instrumentos")
public class InstrumentoController {

    private final InstrumentoService instrumentoService;


    @PostMapping
    @Operation(summary = "Cadastrar instrumento", description = "Registra um novo instrumento")
    @ApiResponse(responseCode = "201", description = "Instrumento cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<InstrumentoResponseDTO> cadastrarIsntrumentos(
            @RequestBody InstrumentoRequestDTO instrumentoDTO,
            @RequestHeader(name = "Authorization", required = false) String token) {
        InstrumentoResponseDTO response = instrumentoService.cadastrarInstrumento(instrumentoDTO, token);
        return ResponseEntity
                .created(URI.create("/instrumentos/" + instrumentoDTO.getId()))
                .body(response);
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Listar por categoria", description = "Lista instrumentos por categoria")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Categoria inválida")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<InstrumentoResponseDTO>> listarIsntrumentosPorCategoria(
            @PathVariable InstrumentoTipo categoria,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(instrumentoService.listarPorTipo(categoria, token));
    }

    @GetMapping
    @Operation(summary = "Listar instrumentos", description = "Lista todos os instrumentos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<InstrumentoResponseDTO>> listarTodosInstrumentos(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(instrumentoService.listarTodos(token));

    }

    @PatchMapping("/{id}/parcial")
    @Operation(summary = "Atualização parcial", description = "Atualiza parcialmente os dados de um instrumento")
    @ApiResponse(responseCode = "200", description = "Instrumento atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Instrumento não encontrado")
    public ResponseEntity<InstrumentoResponseDTO> atualizarIsntrumentosParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(instrumentoService.atualizarParcialmente(id, updates, token));

    }


}
