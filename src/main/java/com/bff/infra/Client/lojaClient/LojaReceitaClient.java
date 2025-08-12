package com.bff.infra.Client.lojaClient;

import com.bff.business.dto.loja.out.ReceitaMensalDTO;
import com.bff.business.dto.loja.out.ReceitaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "loja-receita", url = "${loja.url}")
public interface LojaReceitaClient {

    @GetMapping("/admin/loja/receita")
    ReceitaResponseDTO calcularReceitaLoja(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/loja/receita/mensal/{ano}")
    List<ReceitaMensalDTO> calcularReceitaMensalLoja(
            @PathVariable int ano,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/loja/receita/mensal/{ano}/{mes}")
    ReceitaMensalDTO getReceitaDoMesLoja(
            @PathVariable int ano,
            @PathVariable int mes,
            @RequestHeader("Authorization") String token);
}
