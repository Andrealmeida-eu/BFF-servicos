package com.bff.business.services.escolademusica;


import com.bff.business.dto.escolademusica.out.StatusMensalidadeHistoricoResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.ConfigResponseDTO;
import com.bff.business.dto.escolademusica.out.aluno.MensalidadeResponseDTO;
import com.bff.infra.Client.EscolaClient.EscolaMensalidadeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensalidadeService {

    private final EscolaMensalidadeClient client;

    public void atualizarValorGlobal(BigDecimal novoValor, String token) {
        client.atualizarMensalidades(novoValor, token);
    }

    public MensalidadeResponseDTO marcarComoPaga(Long idMensalidade, LocalDate dataPagamento, String token) {
        return client.marcarComoPaga(idMensalidade, dataPagamento, token);
    }


    public List<StatusMensalidadeHistoricoResponseDTO> buscarHistoricoPorPeriodo(
            Long mensalidadeId, LocalDateTime inicio, LocalDateTime fim, String token) {
        return client.getHistoricoPorPeriodo(mensalidadeId, inicio, fim, token);
    }


    public List<MensalidadeResponseDTO> listarMensalidadesPorAluno(Long alunoId, String token) {
        return client.listarMensalidadesPorAluno(alunoId, token);
    }

    // ==================================== METODOS CONFIG_MENSALIDADE =============================================



    public ConfigResponseDTO criarOuAtualizarConfiguracao(BigDecimal valorMensalidade, Integer diaVencimento, String token) {
        ConfigResponseDTO request = new ConfigResponseDTO();
        request.setValorMensalidade(valorMensalidade);
        request.setDiaVencimento(diaVencimento);
        return client.criarOuAtualizarConfiguracao(request, token);
    }

    public ConfigResponseDTO buscarConfiguracao(String token) {
        return client.buscarConfiguracao(token);
    }


    public void atualizarDiaVencimento(Integer novoDia, String token) {
       client.atualizarDiaVencimento(novoDia, token);


}




}


