package com.bff_studio.alan_godoy.business.dto.escolademusica.enums;

public enum StatusReposicao {
    PENDENTE,       // Solicitação feita, aguardando aprovação
    AGENDADA,       // Reposição agendada
    REALIZADA,      // Reposição concluída
    CANCELADA,      // Reposição cancelada
    NAO_REALIZADA   // Reposição não realizada (aluno faltou)
}