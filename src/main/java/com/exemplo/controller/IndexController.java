package com.exemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/{path:[^\\.]*}"})  // Redireciona todas as rotas para index.html
    public String index() {
        return "forward:/index.html";
    }
}
