package br.com.dio.processo.candidatura;

import java.util.ArrayList;

import static br.com.dio.processo.candidatura.GeradorDeNome.gerarNomeAleatorio;
import static br.com.dio.processo.candidatura.GeradorDeSalario.valorPretendido;

public class AnalisarCandidatos {
    static void analisarCandidato(ArrayList<Candidato> candidatosSelecionados){ // metodo para verificação com if.
        String nome = gerarNomeAleatorio(); // Gerar um nome aleatório do metodo.
        double salarioBase = 2000.0;
        double salarioPretendido = valorPretendido();

        System.out.println("Analisando o cadidato: " + nome);
        System.out.println("Salário pretendido: R$ " + salarioPretendido);

        if (salarioBase > salarioPretendido && candidatosSelecionados.size() < 5) { // condição
            System.out.println("Ligar Candidato");
            candidatosSelecionados.add(new Candidato(nome, salarioPretendido));
        } else if (salarioBase == salarioPretendido && candidatosSelecionados.size() < 5) {
            System.out.println("Ligar para o candidato com contra proposta");
            candidatosSelecionados.add(new Candidato(nome, salarioPretendido));
        } else if (salarioBase < salarioPretendido && candidatosSelecionados.size() < 5){
            System.out.println("Aguardando o resultado dos demais candidatos");
        } else {
            System.out.println("Limite de candidatos selecionados atingido!");
        }

    }
    static void processarCandidatos(){
        ArrayList<Candidato> candidatosSelecionados = new ArrayList<>();

        while (candidatosSelecionados.size() < 5){
            analisarCandidato(candidatosSelecionados);
        }

        //Exibe os candidatos selecionados!
        System.out.println("\nCandidatos Selecionados: ");
        for (Candidato candidato : candidatosSelecionados){
            System.out.println(candidato.getNome() + " - R$ " + candidato.getSalarioPretendido());
        }
    }
}
