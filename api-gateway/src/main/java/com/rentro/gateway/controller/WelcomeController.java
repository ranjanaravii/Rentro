package com.rentro.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {
    
    @GetMapping("/")
    public Map<String, Object> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Rentro API Gateway");
        response.put("version", "1.0.0");
        response.put("status", "UP");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("health", "/actuator/health");
        endpoints.put("user_registration", "POST /api/auth/register");
        endpoints.put("user_login", "POST /api/auth/login");
        endpoints.put("properties", "/api/properties");
        endpoints.put("bookings", "/api/bookings");
        endpoints.put("societies", "/api/societies");
        endpoints.put("notifications", "/api/notifications");
        
        response.put("available_endpoints", endpoints);
        return response;
    }
    
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "API Gateway");
        return response;
    }
}
