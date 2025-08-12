package com.bff.infra.Client.lojaClient;

import com.bff.business.dto.loja.in.VendaRequestDTO;
import com.bff.business.dto.loja.out.VendaResponseDTO;
import com.bff.business.dto.loja.out.VendasMensalResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "loja-venda", url = "${loja.url}")
public interface LojaVendaClient {

    @PostMapping("/admin/loja/vendas")
    VendaResponseDTO realizarVenda(@RequestBody VendaRequestDTO vendaDTO,
                                   @RequestHeader("Authorization") String token);

    @GetMapping("/admin/loja/vendas/periodo")
    List<VendaResponseDTO> listarVendasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/loja/vendas/mensal/{ano}")
    List<VendasMensalResponseDTO> getVendasMensal(@PathVariable int ano,
                                                  @RequestHeader("Authorization") String token);
}
