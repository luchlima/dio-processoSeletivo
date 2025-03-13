package br.com.dio.processo.candidatura;

public class Candidato {
    private String nome;
    private double salario;

    public Candidato(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}
