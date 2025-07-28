package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.AlunoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AlunoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoAlunoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-aluno-client", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaAlunoClient {

    //ENDPOINTS DE ALUNO_CONTROLLER

    @PostMapping("/admin/escola-musica/alunos")
    AlunoResponseDTO cadastrarAluno(@RequestBody AlunoRequestDTO alunoDTO,
                                    @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/alunos/{id}")
    AlunoResponseDTO BuscarAlunoPorId(@PathVariable @Valid Long id,
                                      @RequestHeader(name = "Authorization") String token);

    @GetMapping("admin/escola-musica/alunos/{id}/progresso")
    List<ProgressoAlunoResponseDTO> getProgressao(@PathVariable Long id,
                                                  @RequestHeader("Authorization") String token);

    @PatchMapping("admin/escola-musica/alunos/{id}/parcial")
    AlunoResponseDTO atualizarAlunoParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);

    @GetMapping("admin/escola-musica/alunos")
    List<AlunoResponseDTO> listarTodosAlunos(@RequestHeader("Authorization") String token);

    @DeleteMapping("admin/escola-musica/alunos/{id}")
    void removerAluno(@PathVariable Long id, @RequestHeader("Authorization") String token);


}


