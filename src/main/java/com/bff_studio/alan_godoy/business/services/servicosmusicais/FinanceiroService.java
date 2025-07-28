package com.bff_studio.alan_godoy.business.services.servicosmusicais;


import com.bff_studio.alan_godoy.business.dto.servicosmusicais.out.CategoriaServicoResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.servicosMusicaisClient.ServicosMusicaisFinanceiroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FinanceiroService {

    private final ServicosMusicaisFinanceiroClient client;


    /**
     * Calcula a receita total de todos os pedidos não cancelados
     *
     * @return Valor total da receita
     */
    public BigDecimal calcularReceitaTotal(String token) {
        return client.receitaTotal(token);
    }

    /**
     * Calcula a receita em um período específico
     *
     * @param inicio Data de início do período
     * @param fim    Data final do período
     * @return Valor total da receita no período
     */
    public BigDecimal calcularReceitaPeriodo(LocalDateTime inicio, LocalDateTime fim, String token) {
        return client.receitaPeriodo(inicio, fim, token);
    }

    /**
     * Calcula a receita agrupada por tipo de serviço
     *
     * @return Mapa com tipo de serviço como chave e valor total como valor
     */
    @SuppressWarnings("unchecked")
    public Map<CategoriaServicoResponseDTO, BigDecimal> calcularReceitaPorTipoServico(String token) {
        return (Map<CategoriaServicoResponseDTO, BigDecimal>) client.receitaPorTipoServico(token);
    }


}
