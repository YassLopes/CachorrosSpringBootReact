package com.exemplo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = {"https://cachorrosspringbootreact.onrender.com", "http://localhost:3000"})
@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
    private final RestTemplate restTemplate;

    @Autowired
    public InfoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogResponse> getDogInfo(@PathVariable String id) {
        try {
            String url = "https://dog.ceo/api/breeds/image/random";
            logger.info("Fazendo requisição para: {}", url);
            
            DogApiResponse response = restTemplate.getForObject(url, DogApiResponse.class);
            
            if (response == null) {
                logger.error("Resposta nula recebida da API");
                return ResponseEntity.notFound().build();
            }
            
            logger.info("Resposta recebida com sucesso: {}", response.getMessage());
            
            // Construir a resposta simplificada
            DogResponse dogResponse = new DogResponse();
            dogResponse.setMessage(response.getMessage());
            dogResponse.setStatus(response.getStatus());
            
            return ResponseEntity.ok(dogResponse);
        } catch (Exception e) {
            logger.error("Erro ao processar requisição: ", e);
            return ResponseEntity.internalServerError().build();
        }
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
