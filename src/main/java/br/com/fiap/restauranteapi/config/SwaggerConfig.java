package br.com.fiap.restauranteapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "prod"})
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RestauranteAPI")
                        .version("1.0.0")
                        .description("API para gerenciamento de restaurantes, permitindo controle de operações, pedidos e avaliações de clientes."));
    }
}