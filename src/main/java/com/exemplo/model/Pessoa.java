package com.exemplo.model;

public class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    private String estadoCivil;
    private String profissao;

    public Pessoa(String nome, int idade, String sexo, String estadoCivil, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getSexo() { return sexo; }
    public String getEstadoCivil() { return estadoCivil; }
    public String getProfissao() { return profissao; }
}
