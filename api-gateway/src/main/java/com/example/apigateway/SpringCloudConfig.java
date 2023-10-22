package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

        @Bean
        public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
                return builder.routes()
                                // Micro-service 1
                                .route(r -> r.path("/reservations/**")
                                                .uri("http://localhost:8088/"))

                                // Micro-service 2
                                .route(r -> r.path("/annonce/**")
                                                .uri("http://localhost:9191/"))

                                // Micro-service 2
                                .route(r -> r.path("/review/**")
                                                .uri("http://localhost:8484/"))
                                .build();
        }

}
