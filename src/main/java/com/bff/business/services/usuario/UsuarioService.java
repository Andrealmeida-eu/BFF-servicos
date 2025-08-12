package com.bff.business.services.usuario;


import com.bff.business.dto.usuario.in.EnderecoRequestDTO;
import com.bff.business.dto.usuario.in.TelefoneRequestDTO;
import com.bff.business.dto.usuario.in.UsuarioRequestDTO;
import com.bff.business.dto.usuario.out.EnderecoResponseDTO;
import com.bff.business.dto.usuario.out.TelefoneResponseDTO;
import com.bff.business.dto.usuario.out.UsuarioResponseDTO;
import com.bff.infra.Client.UsuarioClient.UsuarioClient;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public UsuarioResponseDTO salvaAdmin(UsuarioRequestDTO usuarioDTO) {
        return salvaUsuario(usuarioDTO);
    }

    public String login (UsuarioRequestDTO usuarioRequestDTO){
        return client.login(usuarioRequestDTO);
    }


    public UsuarioResponseDTO buscarUsuarioPorEmail(String email, String token) {

        return client.buscaUsuarioPorEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioResponseDTO atualizaDadosUsuario(String token, UsuarioRequestDTO dto) {
        return client.atualizaDadosUsuario(dto, token);

    }

    public EnderecoResponseDTO atualizaEndereco(Long idEndereco, EnderecoRequestDTO enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneResponseDTO atualizaTelefone(Long idTelefone, TelefoneRequestDTO telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoResponseDTO cadastraEndereco(String token, EnderecoRequestDTO dto) {
        return client.cadastraEndereco(dto, token);

    }

    public TelefoneResponseDTO cadastraTelefone(String token, TelefoneRequestDTO dto) {
        return client.cadastraTelefone(dto, token);

    }

    public List<UsuarioResponseDTO> listarTodos(String token) {
        return client.listarTodosUsuarios(token);
    }
}
