package com.rentro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // User Service Routes
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("http://user-service:8081"))
                .route("auth-service", r -> r.path("/api/auth/**")
                        .uri("http://user-service:8081"))
                
                // Property Service Routes
                .route("property-service", r -> r.path("/api/properties/**")
                        .uri("http://property-service:8082"))
                
                // Booking Service Routes
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://booking-service:8083"))
                
                // Notification Service Routes
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://notification-service:8084"))
                
                // Society Service Routes
                .route("society-service", r -> r.path("/api/societies/**")
                        .uri("http://society-service:8085"))
                
                .build();
    }
}
