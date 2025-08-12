package com.bff.business.dto.usuario.out;




import com.bff.business.dto.usuario.Role;
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
