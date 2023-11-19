package br.com.udesc.ceavi.eso.ese.movieservice

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class MovieServiceApplication

fun main(args: Array<String>) {
    runApplication<MovieServiceApplication>(*args)
}

@Configuration
class OpenApiConfig() {
    @Bean
    fun usersMicroserviceOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Movie-Web-Service")
                    .description("A Movie web service")
                    .version("1.0")
            )
    }
}

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }
}
