package com.exemplo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"https://springbootcachorrosreact.onrender.com", "http://localhost:3000"})
@RestController
@RequestMapping("/info")
public class InfoController {

    @GetMapping("/{id}")
    public ResponseEntity<DogResponse> getDogInfo(@PathVariable String id) {
        String url = "https://dog.ceo/api/breeds/image/random";
        
        RestTemplate restTemplate = new RestTemplate();
        DogApiResponse response = restTemplate.getForObject(url, DogApiResponse.class);
        
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Construir a resposta simplificada
        DogResponse dogResponse = new DogResponse();
        dogResponse.setMessage(response.getMessage());
        dogResponse.setStatus(response.getStatus());
        
        return ResponseEntity.ok(dogResponse);
    }

    // Classe para mapear a resposta da Dog API
    private static class DogApiResponse {
        private String message;
        private String status;
        
        // Getters e Setters
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
    
    // Classe para a resposta simplificada
    private static class DogResponse {
        private String message;
        private String status;
        
        // Getters e Setters
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
} 
