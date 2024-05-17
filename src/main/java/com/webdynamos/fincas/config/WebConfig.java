package com.webdynamos.fincas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry){
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200") // Reemplaza con el origen de tu aplicación Angular
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
    }

}
