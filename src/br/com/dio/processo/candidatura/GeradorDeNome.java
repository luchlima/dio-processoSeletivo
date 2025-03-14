package br.com.dio.processo.candidatura;

import java.util.Random;

public class GeradorDeNome {
    static String gerarNomeAleatorio(){ // metodo para chamar um nome aleatório.
        String[] nomes = {"AMANDA", "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "CARLOS", "LUCAS", "FERNANDA"};

        Random random = new Random();
        int indiceAleatorio = random.nextInt(nomes.length);// Gera um índice aleatório para escolher o nome.
        return nomes[indiceAleatorio]; // retorna um nome aleatório do índice escolhido.
    }
}
