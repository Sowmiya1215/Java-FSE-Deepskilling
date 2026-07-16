package com.cognizant.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("greet-service", r -> r
                        .path("/greet-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8085"))
                .build();
    }
}