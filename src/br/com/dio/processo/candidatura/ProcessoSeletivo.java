package br.com.dio.processo.candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        double salarioPretendido = valorPretendido();
        analisarCandidato(salarioPretendido);

        selecaoCandidatos();
    }

    static void analisarCandidato(double salarioPretendido){ // metodo para verificação com if
        double salarioBase = 2000.0;
        String resultado = (salarioBase > salarioPretendido) ? // condição
                "Ligar Candidato" :
                (salarioBase == salarioPretendido) ? // condição
                        "Ligar para o candidato com contra proposta" :
                        "Aguardando o resultado dos demais candidatos";
        System.out.println(resultado);
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        ArrayList<Candidato> candidatosEscolhidos = new ArrayList<>();

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + ", Solicitou este valor de salário R$ " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + ", foi selecionado para a vaga!");
                candidatosEscolhidos.add(new Candidato(candidato, salarioPretendido));
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        System.out.println("\nCandidatos Selecionados:");
        for (Candidato candidatoEscolhido: candidatosEscolhidos){
            System.out.println(candidatoEscolhido.getNome() + " - R$ " + candidatoEscolhido.getSalario());
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuarTentando && tentativasRealizadas <3);

        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa!");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", número maximo de tentativas " + tentativasRealizadas + " realizadas!");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static double valorPretendido(){ // metodo para gerar um número aleatório entre 1800 até 2000
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

}