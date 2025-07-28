package com.bff_studio.alan_godoy.business.services.escolademusica;



import com.bff_studio.alan_godoy.business.dto.escolademusica.in.aluno.AlunoRequestDTO;
import com.bff_studio.alan_godoy.business.dto.escolademusica.out.aluno.AlunoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.EscolaClient.EscolaAlunoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AlunoService {


    private final EscolaAlunoClient client;


    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO alunoDTO, String token) {
        return client.cadastrarAluno(alunoDTO, token);
    }

    public void deletarAluno(Long id, String token) {
     client.removerAluno(id, token);
    }

    public AlunoResponseDTO buscarPorId(Long idAluno, String token) {
        return client.BuscarAlunoPorId(idAluno, token);
    }


    public List<AlunoResponseDTO> listarTodos(String token) {
        return client.listarTodosAlunos(token);
    }

    public AlunoResponseDTO atualizarParcialmente(Long id, Map<String, Object> updates, String token) {
        return client.atualizarAlunoParcialmente(id, updates, token);

    }




}







