package com.bff_studio.alan_godoy.business.services.loja;


import com.bff_studio.alan_godoy.business.dto.loja.in.VendaRequestDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.VendaResponseDTO;
import com.bff_studio.alan_godoy.business.dto.loja.out.VendasMensalResponseDTO;
import com.bff_studio.alan_godoy.infra.Client.lojaClient.LojaVendaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// VendaService.java
@Service
@RequiredArgsConstructor
public class VendaService {

    private final LojaVendaClient vendaClient;


    /**
     * Realiza uma nova venda no sistema
     *
     * @param vendaDTO DTO contendo os dados da venda e itens
     * @return VendaDTO com os dados da venda realizada
     */

    public VendaResponseDTO realizarVenda(VendaRequestDTO vendaDTO, String token) {
        return vendaClient.realizarVenda(vendaDTO, token);
    }


    /**
     * Lista todas as vendas em um período específico
     *
     * @param inicio Data de início do período
     * @param fim    Data final do período
     * @return Lista de VendaDTO com as vendas do período
     */
    public List<VendaResponseDTO> listarVendasPorPeriodo(LocalDate inicio,
                                                         LocalDate fim,
                                                         String token) {
        return vendaClient.listarVendasPorPeriodo(inicio, fim, token);
    }

    /**
     * Consulta a quantidade de vendas por mês em um ano específico
     *
     * @param ano Ano para consulta
     * @return Lista de VendasMensalDTO com a quantidade de vendas por mês
     */
    public List<VendasMensalResponseDTO> consultarQuantidadeVendasMensal(int ano, String token) {
        return vendaClient.getVendasMensal(ano, token);
    }
}

