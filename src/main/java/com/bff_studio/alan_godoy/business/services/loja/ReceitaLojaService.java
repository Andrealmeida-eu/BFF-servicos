package com.bff_studio.alan_godoy.business.services.loja;


import com.bff_studio.alan_godoy.business.dto.loja.out.ReceitaMensalDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.ReceitaResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.lojaClient.LojaReceitaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaLojaService {


    private final LojaReceitaClient receitaClient;

    /**
     * Calcula a receita total, custo total e lucro total em um período específico
     *
     * @param inicio Data de início do período
     * @param fim    Data final do período
     * @return ReceitaDTO contendo os valores calculados
     */
    public ReceitaResponseDTO calcularReceita(LocalDate inicio, LocalDate fim, String token) {
        return receitaClient.calcularReceitaLoja(inicio, fim, token);
    }


    /**
     * Calcula a receita mensal para todos os meses de um ano específico
     *
     * @param ano Ano para cálculo
     * @return Lista de ReceitaMensalDTO com os dados de cada mês
     */
    public List<ReceitaMensalDTO> calcularReceitaMensal(int ano, String token) {
        return receitaClient.calcularReceitaMensalLoja(ano, token);
    }

    /**
     * Consulta a receita de um mês específico
     *
     * @param ano Ano para consulta
     * @param mes Mês para consulta (1-12)
     * @return ReceitaMensalDTO com os dados do mês
     */
    public ReceitaMensalDTO consultarReceitaDoMes(int ano, int mes, String token) {
        return receitaClient.getReceitaDoMesLoja(ano, mes, token);
    }


}