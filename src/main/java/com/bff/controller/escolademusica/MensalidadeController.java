package com.bff.controller.escolademusica;

import com.bff.business.dto.escolademusica.out.StatusMensalidadeHistoricoResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.ConfigResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.MensalidadeResponseDTO;
import com.bff.business.services.escolademusica.MensalidadeService;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequiredArgsConstructor
@RequestMapping("/admin/escola-musica")
@Tag(name = "Mensalidades", description = "Operações relacionadas a mensalidades")
public class MensalidadeController {

    private final MensalidadeService mensalidadeService;

    @PostMapping("/mensalidade/atualizar-mensalidades")
    @Operation(summary = "Atualizar valor", description = "Atualiza o valor global das mensalidades")
    @ApiResponse(responseCode = "200", description = "Valor atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Valor inválido")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<Void> atualizarMensalidades(@RequestParam BigDecimal novoValor,
                                                    @RequestHeader(name = "Authorization", required = false) String token) {
        mensalidadeService.atualizarValorGlobal(novoValor, token);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mensalidade/{alunoId}")
    @Operation(summary = "Mensalidades por aluno", description = "Lista as mensalidades de um aluno")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<List<MensalidadeResponseDTO>> listarMensalidadesPorAluno(@PathVariable Long alunoId,
                                                                                 @RequestHeader(name = "Authorization", required = false) String token) {
        List<MensalidadeResponseDTO> mensalidades = mensalidadeService.listarMensalidadesPorAluno(alunoId, token);
        return ResponseEntity.ok(mensalidades);
    }

    @PutMapping("/mensalidade/{id}/pagar")
    @Operation(summary = "Marcar como paga", description = "Registra o pagamento de uma mensalidade")
    @ApiResponse(responseCode = "200", description = "Mensalidade atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Data inválida")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Mensalidade não encontrada")
    public ResponseEntity<MensalidadeResponseDTO> marcarComoPaga(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataPagamento,
          @RequestHeader(name = "Authorization", required = false) String token) {

        LocalDate data = dataPagamento != null ? dataPagamento : LocalDate.now();
        return ResponseEntity.ok(mensalidadeService.marcarComoPaga(id, data, token));
    }


    @GetMapping("/mensalidade/{mensalidadeId}/periodo")
    @Operation(summary = "Histórico por período", description = "Busca o histórico de status de uma mensalidade em um período")
    @ApiResponse(responseCode = "200", description = "Histórico retornado com sucesso")
    @ApiResponse(responseCode = "400", description = "Datas inválidas")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Mensalidade não encontrada")
    public ResponseEntity<List<StatusMensalidadeHistoricoResponseDTO>> getHistoricoPorPeriodo(
            @PathVariable Long mensalidadeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
          @RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(mensalidadeService.buscarHistoricoPorPeriodo(mensalidadeId, inicio, fim, token));
    }



    // ==================================== ENDPOINTS CONFIG_MENSALIDADE =============================================

    @PutMapping("/mensalidade/config/dia-vencimento")
    @Operation(summary = "Atualizar dia de vencimento",
            description = "Altera o dia padrão de vencimento das mensalidades")
    @ApiResponse(responseCode = "200", description = "Dia de vencimento atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dia inválido (deve ser entre 1 e 31)")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Configuração não encontrada")
    public ResponseEntity<Void> atualizarDiaVencimento(@RequestParam Integer novoDia,
                                                       @RequestHeader(name = "Authorization", required = false) String token) {
        mensalidadeService.atualizarDiaVencimento(novoDia, token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mensalidade/config/criar")
    @Operation(summary = "Criar/atualizar configuração",
            description = "Cria ou atualiza a configuração padrão de mensalidades")
    @ApiResponse(responseCode = "200", description = "Configuração salva com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<ConfigResponseDTO> criarOuAtualizarConfiguracao(
            @RequestBody ConfigResponseDTO request,
            @RequestHeader(name = "Authorization", required = false) String token) {
        var config = mensalidadeService.criarOuAtualizarConfiguracao(
                request.getValorMensalidade(),
                request.getDiaVencimento(),
                token
        );
        return ResponseEntity.ok(config);
    }

    @GetMapping("/mensalidade/config/listar")
    @Operation(summary = "Obter configuração atual",
            description = "Retorna a configuração padrão de mensalidades vigente")
    @ApiResponse(responseCode = "200", description = "Configuração encontrada")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Configuração não encontrada")
    public ResponseEntity<ConfigResponseDTO> buscarConfiguracao(@RequestHeader(name = "Authorization", required = false) String token) {
        ConfigResponseDTO config = mensalidadeService.buscarConfiguracao(token);
        return ResponseEntity.ok(config);
    }


}
