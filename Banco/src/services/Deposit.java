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
            float valor;
            System.out.println("Saldo disponível no App: " + bradesco.getSaldoApp());
            System.out.println("Cofrinhos: ");
            System.out.println("Cofrinho Pc" + bradesco.getCofrinhoPc());
            System.out.println("Cofrinho Casa" + bradesco.getCofrinhoCasa());

            System.out.println("---- Selecione onde você deseja depositar: ");
            System.out.println("1 - Cofrinho Pc");
            System.out.println("2 - Cofrinho Casa");
            int opcao = sc.nextInt();
            sc.nextLine();

                if (opcao == 1) {
                    if (bradesco.getSaldoApp() >= valor) {
                        System.out.println("Digite o valor para depositar");
                        valor = sc.nextFloat();
                        sc.nextLine();

                        float deposito1 = bradesco.getSaldoApp() - valor;
                        bradesco.setCofrinhoPc(valor);
                    } else {
                        if (bradesco.getSaldoApp() < valor) {
                            System.out.println("Saldo insuficiente");


                        }
                    }
                } else if (opcao == 2) {
                    if (bradesco.getSaldoApp() >= valor) {
                        System.out.println("Digite o valor para depositar");
                        valor = sc.nextFloat();
                        sc.nextLine();
                        float deposito2 = bradesco.getSaldoApp() - valor;
                        bradesco.setCofrinhoCasa(deposito2);
                    }
                    if (bradesco.getSaldoApp() < valor) {
                        System.out.println("Saldo insuficiente");
                    }
                }
        } catch (Exception e) {
            System.out.println("Um Erro inesperado aconteceu, tente novamente.");
        }
    }

}
