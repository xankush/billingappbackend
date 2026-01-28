package com.billapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "https://digitaltentsuppliesrentmanagementapp.netlify.app",
                    "http://localhost:8080",
                    "http://localhost:8082",      // React dev server?
                    "http://192.168.1.5:8080",   // Your LAN IP
                    "http://127.0.0.1:8082"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}
