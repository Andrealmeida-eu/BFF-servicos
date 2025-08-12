package com.bff.business.services.escolademusica;


import com.bff.business.dto.escolademusica.enums.InstrumentoTipo;
import com.bff.business.dto.escolademusica.in.instrumento.InstrumentoRequestDTO;
import com.bff.business.dto.escolademusica.out.instrumento.InstrumentoResponseDTO;
import com.bff.infra.Client.EscolaClient.EscolaInstrumentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InstrumentoService {

    private final EscolaInstrumentoClient client;

    public InstrumentoResponseDTO cadastrarInstrumento(InstrumentoRequestDTO instrumentoDTO,
                                                       String token) {
        return client.cadastrarIsntrumentos(instrumentoDTO, token);
    }

    public List<InstrumentoResponseDTO> listarPorTipo(InstrumentoTipo categoria,
                                                      String token) {
        return client.listarIsntrumentosPorCategoria(categoria, token);
    }


    public List<InstrumentoResponseDTO> listarTodos(String token) {
        return client.listarTodosInstrumentos(token);


    }

    public InstrumentoResponseDTO atualizarParcialmente(Long id,
                                                        Map<String, Object> updates,
                                                        String token) {
        return client.atualizarIsntrumentosParcialmente(id, updates, token);

    }
}


