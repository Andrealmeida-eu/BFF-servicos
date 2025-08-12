package com.bff.infra.Client.EscolaClient;

import com.bff.business.dto.escolademusica.in.aluno.ProfessorRequestDTO;
import com.bff.business.dto.escolademusica.out.aluno.ProfessorResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-professor", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaProfessorClient {

    @PostMapping("/admin/escola-musica/professores")
    ProfessorResponseDTO cadastrarProfessor(
            @RequestBody ProfessorRequestDTO professorDTO,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/professores")
    List<ProfessorResponseDTO> listarTodosProfessores(@RequestHeader("Authorization") String token);

    @PatchMapping("/admin/escola-musica/professores/categoria/{id}/parcial")
    ProfessorResponseDTO atualizarProfessorParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);
}
