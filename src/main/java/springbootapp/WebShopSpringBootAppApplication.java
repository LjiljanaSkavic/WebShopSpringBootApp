package springbootapp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class WebShopSpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebShopSpringBootAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return new ModelMapper();
    }

    @Configuration

    public class SwaggerConfig {
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI().info(apiInfo());
        }

        private Info apiInfo() {
            return new Info()
                    .title("Liki u akciji")
                    .description("Web shop app")
                    .version("1.0")
                    .contact(null)
                    .license(null);
        }
    }
}
