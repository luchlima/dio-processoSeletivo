package br.com.dio.processo.candidatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class GeradorDeSalario {
    static double valorPretendido(){ // metodo para gerar um número aleatório entre 1800 até 2000
        double valor = ThreadLocalRandom.current().nextDouble(1800, 2200);// salário aleatorio gerado

        //Arredonda o valor para 2 casas decimais usando o bigDecimal
        BigDecimal valorArredondado = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);

        return  valorArredondado.doubleValue();
    }
}
