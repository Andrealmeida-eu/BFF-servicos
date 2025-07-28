package com.bff_studio.alan_godoy.business.dto.usuario.out;




import com.bff_studio.alan_godoy.business.dto.usuario.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoResponseDTO> enderecos;
    private List<TelefoneResponseDTO> telefones;
    private Role role;
}
