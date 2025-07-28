package com.bff_studio.alan_godoy.business.dto.usuario.in;


import com.bff_studio.alan_godoy.business.dto.usuario.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoRequestDTO> enderecos;
    private List<TelefoneRequestDTO> telefones;
    private Role role;
}
