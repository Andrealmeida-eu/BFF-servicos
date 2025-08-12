package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.out.receita.ReceitaResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "escola-receita", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaReceitaClient {


    @GetMapping
    ReceitaResponseDTO calcularReceitaEscola(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("pagas")
    long contarPagasEscola(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("nao-pagas")
    long contarNaoPagaEscolas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader("Authorization") String token);
}
