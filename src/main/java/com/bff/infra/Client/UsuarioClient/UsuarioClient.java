package com.bff.infra.Client.UsuarioClient;


import com.bff.business.dto.usuario.in.EnderecoRequestDTO;
import com.bff.business.dto.usuario.in.TelefoneRequestDTO;
import com.bff.business.dto.usuario.in.UsuarioRequestDTO;
import com.bff.business.dto.usuario.out.EnderecoResponseDTO;
import com.bff.business.dto.usuario.out.TelefoneResponseDTO;
import com.bff.business.dto.usuario.out.UsuarioResponseDTO;
import com.bff.infra.Client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "usuario", url = "${usuario.url}",configuration = FeignConfig.class)
public interface UsuarioClient {

    @GetMapping("/usuario/buscar-por-email")
    UsuarioResponseDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping("/usuario")
    UsuarioResponseDTO salvaUsuario(@RequestBody UsuarioRequestDTO usuarioDTO);


    @PostMapping("/usuario/login")
    String login(@RequestBody UsuarioRequestDTO usuarioDTO);


    @DeleteMapping("/usuario/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/usuario")
    UsuarioResponseDTO atualizaDadosUsuario(@RequestBody UsuarioRequestDTO dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/endereco")
    EnderecoResponseDTO atualizaEndereco(@RequestBody EnderecoRequestDTO dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/telefone")
    TelefoneResponseDTO atualizaTelefone(@RequestBody TelefoneRequestDTO dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/endereco")
    EnderecoResponseDTO cadastraEndereco(@RequestBody EnderecoRequestDTO dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/telefone")
    TelefoneResponseDTO cadastraTelefone(@RequestBody TelefoneRequestDTO dto,
                                         @RequestHeader("Authorization") String token);

    @GetMapping("/usuario")
    List<UsuarioResponseDTO> listarTodosUsuarios(@RequestHeader("Authorization") String token);
}
