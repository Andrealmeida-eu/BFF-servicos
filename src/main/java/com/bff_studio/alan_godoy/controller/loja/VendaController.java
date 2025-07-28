package com.bff_studio.alan_godoy.controller.loja;


import com.bff_studio.alan_godoy.business.dto.loja.in.VendaRequestDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.VendaResponseDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.VendasMensalResponseDTO;
import com.bff_studio.alan_godoy.business.services.loja.VendaService;
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

// VendaController.java
@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/admin/loja/vendas")
@Tag(name = "Vendas", description = "Operações relacionadas a vendas")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    @Operation(summary = "Realizar venda", description = "Registra uma nova venda")
    @ApiResponse(responseCode = "201", description = "Venda registrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<VendaResponseDTO> realizarVenda(@RequestBody VendaRequestDTO vendaDTO,
                                                        @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.realizarVenda(vendaDTO, token));
    }

    @GetMapping("/periodo")
    @Operation(summary = "Vendas por período", description = "Lista vendas em um período específico")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<VendaResponseDTO>> listarVendasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
          @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(vendaService.listarVendasPorPeriodo(inicio, fim, token));
    }

    @GetMapping("/mensal/{ano}")
    @Operation(summary = "Vendas mensais", description = "Consulta quantidade de vendas por mês em um ano")
    @ApiResponse(responseCode = "200", description = "Dados retornados com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<VendasMensalResponseDTO>> getVendasMensal(@PathVariable int ano,
                                                                       @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(vendaService.consultarQuantidadeVendasMensal(ano, token));
    }
}

