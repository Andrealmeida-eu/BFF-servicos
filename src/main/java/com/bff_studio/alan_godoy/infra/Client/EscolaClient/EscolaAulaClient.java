package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.AulaFilterDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AulaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;


@FeignClient(name = "escola-aula-client", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaAulaClient {

    //ENDPOINTS AULA_CONTROLLER

    @GetMapping("" +
            "" +
            "" +
            "" +
            "" +
            "")
    List<AulaResponseDTO> buscarPorAluno(@PathVariable Long alunoId,
                                         @RequestHeader("Authorization") String token);
    @GetMapping("/admin/escola-musica/aula/proximas/{alunoId}")
    List<AulaResponseDTO> buscarProximasAulas(
            @PathVariable Long alunoId,
            @RequestParam(defaultValue = "4") int semanas,
            @RequestHeader(name = "Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/{id}")
    AulaResponseDTO buscarAulasPorId(@PathVariable Long id,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/todas")
   List<AulaResponseDTO> buscarTodasAulas( @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/hoje")
    List<AulaResponseDTO> buscarAulasHoje(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/semana")
    List<AulaResponseDTO> buscarAulasEstaSemana(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/mes")
    List<AulaResponseDTO> buscarAulasEsteMes(@RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/dia/{diaSemana}")
    List<AulaResponseDTO> buscarPorDiaSemana(@PathVariable DayOfWeek diaSemana,
                                             @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/aula/filtro")
    List<AulaResponseDTO> buscarComFiltro(@RequestBody AulaFilterDTO filtro,
                                          @RequestHeader("Authorization") String token);


}
