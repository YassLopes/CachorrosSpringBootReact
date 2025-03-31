package com.exemplo.controller;

import com.exemplo.model.DogResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = {"https://springbootcachorrosreact.onrender.com", "http://localhost:3000"})
public class InfoController {

    private final RestTemplate restTemplate;

    @Autowired
    public InfoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/info")
    public DogResponse getInfo() {
        String url = "https://dog.ceo/api/breeds/image/random";
        return restTemplate.getForObject(url, DogResponse.class);
    }
} 