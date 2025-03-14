package br.com.dio.processo.candidatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        processarCandidatos();
    }

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

    static String gerarNomeAleatorio(){ // metodo para chamar um nome aleatório.
        String[] nomes = {"AMANDA", "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "CARLOS", "LUCAS", "FERNANDA"};

        Random random = new Random();
        int indiceAleatorio = random.nextInt(nomes.length);// Gera um índice aleatório para escolher o nome.
        return nomes[indiceAleatorio]; // retorna um nome aleatório do índice escolhido.
    }

    static double valorPretendido(){ // metodo para gerar um número aleatório entre 1800 até 2000
        double valor = ThreadLocalRandom.current().nextDouble(1800, 2200);// numero aleatório de 1800 a 2200

        //Arredonda o valor para 6 casas decimais usando o bigDecimal
        BigDecimal valorArredondado = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);

        return  valorArredondado.doubleValue();
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

//    static void selecaoCandidatos(){
//        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA"};
//
//        int candidatosSelecionados = 0;
//        int candidatoAtual = 0;
//        double salarioBase = 2000.0;
//
//        ArrayList<Candidato> candidatosEscolhidos = new ArrayList<>();
//
//        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
//            String candidato = candidatos[candidatoAtual];
//            double salarioPretendido = valorPretendido();
//
//            System.out.println("O candidato " + candidato + ", Solicitou este valor de salário R$ " + salarioPretendido);
//            if (salarioBase >= salarioPretendido){
//                System.out.println("O candidato " + candidato + ", foi selecionado para a vaga!");
//                candidatosEscolhidos.add(new Candidato(candidato, salarioPretendido));
//                candidatosSelecionados++;
//            }
//            candidatoAtual++;
//        }
//        System.out.println("\nCandidatos Selecionados:");
//        for (Candidato candidatoEscolhido: candidatosEscolhidos){
//            System.out.println(candidatoEscolhido.getNome() + " - R$ " + candidatoEscolhido.getSalario());
//        }
//    }

//    static void entrandoEmContato(String candidato){
//        int tentativasRealizadas = 1;
//        boolean continuarTentando = true;
//        boolean atendeu = false;
//        do {
//            atendeu = atender();
//            continuarTentando = !atendeu;
//            if (continuarTentando){
//                tentativasRealizadas++;
//            } else {
//                System.out.println("Contato realizado com sucesso!");
//            }
//        } while (continuarTentando && tentativasRealizadas <3);
//
//        if (atendeu){
//            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa!");
//        } else {
//            System.out.println("Não conseguimos contato com " + candidato + ", número maximo de tentativas " + tentativasRealizadas + " realizadas!");
//        }
//    }
//
//    static boolean atender(){
//        return new Random().nextInt(3)==1;
//    }



}