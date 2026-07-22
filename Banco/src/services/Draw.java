package services;
import domain.Bradesco;
import domain.Cliente;
import test.App;

import java.util.Scanner;

public class Draw {
Bradesco bradesco = new Bradesco();

    public void sacar(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione a opção de onde deseja sacar");
        System.out.println("1 - Cofrinho Pc");
        System.out.println("2 - Cofrinho Casa");
        float valor;

            if (input.nextInt() == 1) {
                System.out.println("Digite o valor a ser sacado");
                valor = input.nextFloat();
                    if (valor <= 0) {
                        System.out.println("O valor deve ser maior ou igual a zero");
                    } else {
                        double soma = bradesco.setSaldoBancario(valor);
                        bradesco.setSaldoBancario(valor);
                    }
            }
    }
}
