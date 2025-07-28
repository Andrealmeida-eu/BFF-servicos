package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.enums.StatusTopico;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoDetalhadoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoResumoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.progresso.ProgressoTopicoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "escola-progresso", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaProgressoClient {




    @PatchMapping("/escola-musica/progresso/alunos/{alunoId}/topicos/{topicoId}/iniciar")
    ProgressoTopicoResponseDTO iniciarTopico(@PathVariable Long alunoId,
                                             @PathVariable Long topicoId,
                                             @RequestHeader("Authorization") String token);

    @PostMapping
    void atualizarProgresso(@RequestBody StatusTopico progressoDTO,
                            @RequestHeader("Authorization") String token);


    @PatchMapping("/escola-musica/progresso/topicos/{topicoId}/concluir")
    ProgressoTopicoResponseDTO concluirTopico(@PathVariable Long topicoId,
                                              @RequestHeader("Authorization") String token);

    @GetMapping("/escola-musica/progresso/aluno/{alunoId}/resumo")
    ProgressoResumoResponseDTO getResumoAluno(@PathVariable Long alunoId,
                                              @RequestHeader("Authorization") String token);

    @GetMapping("/escola-musica/progresso/aluno/{alunoId}/proximos-topicos")
    List<ProgressoTopicoResponseDTO> getProximosTopicos(@PathVariable Long alunoId,
                                                        @RequestHeader("Authorization") String token);

    @GetMapping("/escola-musica/progresso/aluno/{alunoId}/proximas-disciplinas")
    List<ProgressoDetalhadoResponseDTO.ProgressoDisciplinaDTO> getProximasDisciplinas(
            @PathVariable Long alunoId,
            @RequestHeader("Authorization") String token);
}
