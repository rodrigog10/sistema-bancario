package services;

import domain.Bradesco;
import domain.Cliente;
import test.App;

import java.util.Scanner;

public class Deposit {
    Scanner sc = new Scanner(System.in);
    Bradesco bradesco = new  Bradesco();

    public void depositar(Cliente cliente) {
        try {
           int soma = 0;
            System.out.println("BRADESCO - Saldo bancário disponpivel: " + bradesco.getSaldoBancario());
            System.out.println("Digite o valor a ser depositado: (0 para sair)");
            float  valor = sc.nextFloat();
            sc.nextLine();
            soma += valor;
            bradesco.setSaldoBancario(soma);

            float novoSaldo = bradesco.getSaldoBancario() + soma;
            bradesco.setSaldoBancario(novoSaldo);

            System.out.println("Deposito efetuado com sucesso! O valor " + valor + "Foi adicionado ao seu saldo bancário.");
            return;
        } catch (Exception e) {
            System.out.println("Um Erro inesperado aconteceu, tente novamente.");
        }




    }

}
