package com.bff.business.services.escolademusica;


import com.bff.business.dto.escolademusica.in.aluno.ProfessorRequestDTO;
import com.bff.business.dto.escolademusica.out.aluno.ProfessorResponseDTO;
import com.bff.infra.Client.EscolaClient.EscolaProfessorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final EscolaProfessorClient client;

    public ProfessorResponseDTO cadastrarProfessor(ProfessorRequestDTO professorDTO, String token) {
        return client.cadastrarProfessor(professorDTO, token);
    }


    public List<ProfessorResponseDTO> listarTodos(String token) {
        return client.listarTodosProfessores(token);
    }


    public ProfessorResponseDTO atualizarParcialmente(Long id,
                                                      Map<String, Object> updates,
                                                      String token) {
        return client.atualizarProfessorParcialmente(id, updates, token);
    }


}
