package com.bff_studio.alan_godoy.infra.Client.EscolaClient;

import com.bff_studio.alan_godoy.business.dto.escolademusica.in.conteudo.ConteudoProgramaticoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.conteudo.DisciplinaRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.in.conteudo.TopicoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.conteudo.ConteudoProgramaticoResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.conteudo.DisciplinaResponseDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.conteudo.TopicoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "escola-conteudo-programatico", url = "${escola.url}", configuration = FeignConfig.class)
public interface EscolaConteudoProgramaticoClient {


    //===========ENDPOINTS CONTEUDO PROGRAMATICO_CONTROLLER=========

// ========== ENDPOINTS PRINCIPAIS ========== //

    @PostMapping("/admin/escola-musica/conteudo-programatico")
    ConteudoProgramaticoResponseDTO criarConteudoCompleto(@RequestBody ConteudoProgramaticoRequestDTO dto,
                                                    @RequestHeader("Authorization") String token);

    @PutMapping("/admin/escola-musica/conteudo-programatico/{instrumentoId}")
    ConteudoProgramaticoResponseDTO atualizarConteudoCompleto(
            @PathVariable Long instrumentoId,
            @RequestBody ConteudoProgramaticoRequestDTO dto,
            @RequestHeader("Authorization") String token);


    // ========== ENDPOINTS DE CONSULTA ========== //

    @GetMapping("/admin/escola-musica/conteudo-programatico/instrumento/{instrumentoId}")
    ConteudoProgramaticoResponseDTO buscarConteudoCompleto(
            @PathVariable Long instrumentoId,
            @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/conteudo-programatico")
    List<ConteudoProgramaticoResponseDTO> listarTodosConteudos(@RequestHeader("Authorization") String token);

    // ========== ENDPOINTS DE DISCIPLINAS ========== //

    @PostMapping("/admin/escola-musica/conteudo-programatico/disciplinas")
    DisciplinaResponseDTO adicionarDisciplina(
            @RequestBody DisciplinaRequestDTO dto,
            @RequestHeader("Authorization") String token);

    @PutMapping("/admin/escola-musica/conteudo-programatico/disciplinas/{disciplinaId}")
    DisciplinaResponseDTO atualizarDisciplina(
            @PathVariable Long disciplinaId,
            @RequestBody DisciplinaRequestDTO dto,
            @RequestHeader("Authorization") String token);

    @DeleteMapping("/admin/escola-musica/conteudo-programatico/disciplinas/{id}")
    void excluirDisciplina(@PathVariable Long id,
                           @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/conteudo-programatico/disciplinas")
    List<DisciplinaResponseDTO> listarDisciplinas(@RequestHeader("Authorization") String token);

    // ========== ENDPOINTS DE TÓPICOS ========== //

    @PostMapping("/admin/escola-musica/conteudo-programatico/topicos")
    TopicoResponseDTO adicionarTopico(
            @RequestBody TopicoRequestDTO dto,
            @RequestHeader("Authorization") String token);

    @PutMapping("/admin/escola-musica/conteudo-programatico/topicos/{topicoId}")
    TopicoResponseDTO atualizarTopico(
            @PathVariable Long topicoId,
            @RequestBody TopicoRequestDTO dto,
            @RequestHeader("Authorization") String token);


    @DeleteMapping("/admin/escola-musica/conteudo-programatico/topicos/{id}")
    void excluirTopico(@PathVariable Long id,
                       @RequestHeader("Authorization") String token);

    @GetMapping("/admin/escola-musica/conteudo-programatico/disciplinas/{disciplinaId}/topicos")
    List<TopicoResponseDTO> listarTopicosPorDisciplina(
            @PathVariable Long disciplinaId,
            @RequestHeader("Authorization") String token);


    // ========== ENDPOINTS DE REMOÇÃO ========== //

    @DeleteMapping("/admin/escola-musica/conteudo-programatico/{instrumentoId}")
    void removerConteudoProgramatico(
            @PathVariable Long instrumentoId,
            @RequestHeader("Authorization") String token);

    @PatchMapping("/admin/escola-musica/conteudo-programatico/{id}/parcial")
    ConteudoProgramaticoResponseDTO atualizarParcialmenteConteudoProg(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates,
            @RequestHeader("Authorization") String token);

}
