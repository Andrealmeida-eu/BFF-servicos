package com.bff.controller.usuario;


import com.bff.business.services.usuario.UsuarioService;
import com.bff.business.dto.usuario.in.EnderecoRequestDTO;
import com.bff.business.dto.usuario.in.TelefoneRequestDTO;
import com.bff.business.dto.usuario.in.UsuarioRequestDTO;
import com.bff.business.dto.usuario.out.EnderecoResponseDTO;
import com.bff.business.dto.usuario.out.TelefoneResponseDTO;
import com.bff.business.dto.usuario.out.UsuarioResponseDTO;
import com.bff.infra.Client.config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "usuario", description = "cadastro e login")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    @Operation(summary = "Salvar usuario", description = "crie um novo usuario")
    @ApiResponse(responseCode = "200", description = "usuario salvo  com sucesso")
    @ApiResponse(responseCode = "400", description = "usuario ja cadastrado")
    @ApiResponse(responseCode = "500", description = "ERRO SERVIDOR")
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario(@RequestBody UsuarioRequestDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar usuário", description = "Realiza o login do usuário e retorna um token JWT")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public String login(@RequestBody UsuarioRequestDTO usuarioDTO) {

        return usuarioService.login(usuarioDTO);
    }


    @GetMapping("/buscar-por-email")
    @Operation(summary = "Buscar usuário por email", description = "Recupera os dados do usuário pelo email")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UsuarioResponseDTO> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo email")
    @ApiResponse(responseCode = "200", description = "Usuário removido com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados do usuário autenticado")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<UsuarioResponseDTO> atualizaDadosUsuario(@RequestBody UsuarioRequestDTO dto,
                                                                   @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço", description = "Atualiza um endereço do usuário pelo ID")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    public ResponseEntity<EnderecoResponseDTO> atualizaEndereco(@RequestBody EnderecoRequestDTO dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone", description = "Atualiza um telefone do usuário pelo ID")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "404", description = "Telefone não encontrado")
    public ResponseEntity<TelefoneResponseDTO> atualizaTelefone(@RequestBody TelefoneRequestDTO dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Cadastrar endereço", description = "Adiciona um novo endereço ao usuário")
    @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<EnderecoResponseDTO> cadastraEndereco(@RequestBody EnderecoRequestDTO dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraEndereco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Cadastrar telefone", description = "Adiciona um novo telefone ao usuário")
    @ApiResponse(responseCode = "200", description = "Telefone cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    public ResponseEntity<TelefoneResponseDTO> cadastraTelefone(@RequestBody TelefoneRequestDTO dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraTelefone(token, dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Recupera todos os usuários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodosUsuarios(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.listarTodos(token));
    }

}
