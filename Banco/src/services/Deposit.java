package services;

import domain.Bradesco;
import domain.Cliente;
import test.App;

import java.util.Scanner;

public class Deposit {
    Scanner input = new Scanner(System.in);

    public void depositar(Cliente cliente) {
        Bradesco conta = cliente.getConta();

        try {
            float valor;
            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("Cofrinhos: ");
            System.out.println("Cofrinho PC: R$ " + conta.getCofrinhoPc());
            System.out.println("Cofrinho Casa: R$ " + conta.getCofrinhoCasa());
            System.out.println("---- Selecione onde você deseja depositar: ");
            System.out.println("1 - Cofrinho PC");
            System.out.println("2 - Cofrinho Casa");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o valor para depositar (0 para sair):");
                valor = input.nextFloat();
                input.nextLine();

                if (conta.getSaldoApp() >= valor) {
                    conta.setSaldoApp(conta.getSaldoApp() - valor);
                    conta.setCofrinhoPc(conta.getCofrinhoPc() + valor);
                    System.out.println("Valor guardado no Cofrinho PC com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");

                }

            } else if (opcao == 2) {
                System.out.println("Digite o valor para depositar (0 para sair):");
                valor = input.nextFloat();
                input.nextLine();

                if (conta.getSaldoApp() >= valor) {
                    conta.setSaldoApp(conta.getSaldoApp() - valor);
                    conta.setCofrinhoCasa(conta.getCofrinhoCasa() + valor);
                    System.out.println("Valor guardado no Cofrinho Casa com sucesso!");

                } else if (input.nextInt() == 0){
                    System.out.println("Voltando para o menu..");
                    return;
                }

            } else {

                System.out.println("Opção inválida! Retornando ao menu...");
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}