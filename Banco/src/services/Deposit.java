package services;

import domain.Bradesco;
import domain.Cliente;
import java.util.Scanner;

public class Deposit {
    Scanner input = new Scanner(System.in);

    public void depositar(Cliente cliente, Bradesco bradesco) {

        try {
            float valor;
            System.out.println("Saldo disponível no App: R$ " + bradesco.getSaldoApp());
            System.out.println("Cofrinhos: ");
            System.out.println("Cofrinho PC: R$ " + bradesco.getCofrinhoPc());
            System.out.println("Cofrinho Casa: R$ " + bradesco.getCofrinhoCasa());
            System.out.println("---- Selecione onde você deseja depositar: ");
            System.out.println("1 - Cofrinho PC");
            System.out.println("2 - Cofrinho Casa");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o valor para depositar (0 para sair):");
                valor = input.nextFloat();
                input.nextLine();

                if (bradesco.getSaldoApp() >= valor) {
                    bradesco.setSaldoApp(bradesco.getSaldoApp() - valor);
                    bradesco.setCofrinhoPc(bradesco.getCofrinhoPc() + valor);
                    System.out.println("Valor guardado no Cofrinho PC com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                    return;
                }

            } else if (opcao == 2) {
                System.out.println("Digite o valor para depositar (0 para sair):");
                valor = input.nextFloat();
                input.nextLine();

                if (bradesco.getSaldoApp() >= valor) {
                    bradesco.setSaldoApp(bradesco.getSaldoApp() - valor);
                    bradesco.setCofrinhoCasa(bradesco.getCofrinhoCasa() + valor);
                    System.out.println("Valor guardado no Cofrinho Casa com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
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