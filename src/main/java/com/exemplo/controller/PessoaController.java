package com.exemplo.controller;

import com.exemplo.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final Pessoa pessoa;

    public PessoaController(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @GetMapping
    public Pessoa getPessoa() {
        // Printando as informações da Pessoa no console
        System.out.println("=== Informações da Pessoa ===");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Sexo: " + pessoa.getSexo());
        System.out.println("Estado Civil: " + pessoa.getEstadoCivil());
        System.out.println("Profissão: " + pessoa.getProfissao());
        System.out.println("============================");

        return pessoa;
    }
}
