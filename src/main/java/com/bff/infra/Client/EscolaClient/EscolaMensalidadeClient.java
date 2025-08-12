package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.out.StatusMensalidadeHistoricoResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.ConfigResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.MensalidadeResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "escola-mensalidade", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaMensalidadeClient {


    @PostMapping("/admin/escola-musica/mensalidade/atualizar-mensalidades")
    void atualizarMensalidades(@RequestParam BigDecimal novoValor,
                               @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/mensalidade/{alunoId}")
    List<MensalidadeResponseDTO> listarMensalidadesPorAluno(@PathVariable Long alunoId,
                                                            @RequestHeader("Authorization") String token);

    @PutMapping("/admin/escola-musica/mensalidade/{id}/pagar")
    MensalidadeResponseDTO marcarComoPaga(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataPagamento,
            @RequestHeader("Authorization") String token);


    /**
     * Busca histórico por período
     * GET /api/mensalidades/historico/{mensalidadeId}/periodo?inicio=...&fim=...
     */
    @GetMapping("/admin/escola-musica/mensalidade/{mensalidadeId}/periodo")
    List<StatusMensalidadeHistoricoResponseDTO> getHistoricoPorPeriodo(
            @PathVariable Long mensalidadeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fim,
            @RequestHeader("Authorization") String token);


    // ==================================== ENDPOINTS CONFIG_MENSALIDADE =============================================

    @PutMapping("/admin/escola-musica/mensalidade/config/dia-vencimento")
    void atualizarDiaVencimento(@RequestParam Integer novoDia,
                                @RequestHeader("Authorization") String token);

    @PostMapping("/admin/escola-musica/mensalidade/config/criar")
    ConfigResponseDTO criarOuAtualizarConfiguracao(
            @RequestBody ConfigResponseDTO request,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/mensalidade/config/listar")
    ConfigResponseDTO buscarConfiguracao( @RequestHeader("Authorization") String token);


   ;
}
