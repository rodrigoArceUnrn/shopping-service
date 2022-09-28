package ar.edu.unrn.shoppingservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title("API de servicio")
                .description("API para obtener detalles correspondiente a las ventas")
                .version("1.0.0");
    }

}
