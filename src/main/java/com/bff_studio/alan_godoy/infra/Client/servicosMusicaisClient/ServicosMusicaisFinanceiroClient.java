package com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@FeignClient(name = "servicos-musicais-financeiro", url = "${servicos-musicais.url}")
public interface ServicosMusicaisFinanceiroClient {


    @GetMapping("/total")
    BigDecimal receitaTotal(@RequestHeader("Authorization") String token);

    @GetMapping("/periodo")
    BigDecimal receitaPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestHeader("Authorization") String token);


    @GetMapping("/receita-por-servico")
    Object receitaPorTipoServico(@RequestHeader("Authorization") String token);
}
