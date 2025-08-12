package com.bff.infra.Client.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerGroupsConfig {

    @Bean
    public GroupedOpenApi escolaDeMusicaApi() {
        return GroupedOpenApi.builder()
                .group("Escola de Música")
                .pathsToMatch("/admin/escola-musica/**")
                .packagesToScan("com.bff_studio.alan_godoy.controller.escolademusica")
                .build();
    }

    @Bean
    public GroupedOpenApi lojaApi() {
        return GroupedOpenApi.builder()
                .group("Loja")
                .pathsToMatch("/admin/loja/**")
                .packagesToScan("com.bff_studio.alan_godoy.controller.loja")
                .build();
    }


    @Bean
    public GroupedOpenApi servicosMusicaisApi() {
        return GroupedOpenApi.builder()
                .group("Serviços Musicais")
                .pathsToMatch("/admin/servicos-musicais/**")
                .packagesToScan("com.bff_studio.alan_godoy.controller.servicosmusicais")
                .build();
    }

    @Bean
    public GroupedOpenApi usuarioApi() {
        return GroupedOpenApi.builder()
                .group("Usuario")
                .pathsToMatch("/usuario/**")
                .packagesToScan("com.bff_studio.alan_godoy.controller.usuario")
                .build();
    }

}
