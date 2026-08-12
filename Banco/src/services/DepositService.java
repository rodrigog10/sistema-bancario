package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

import java.util.Scanner;

public class DepositService {
    Scanner input = new Scanner(System.in);

    public void depositar(Cliente cliente) {
        Bradesco conta = cliente.getConta();

        try {
            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não tem cofrinhos registrados.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== SEUS COFRINHOS ===");
            System.out.println("Selecione o cofrinho no qual deseja depositar: ");

            for (int i = 0; i < conta.getCofres().size(); i++) {
                CofreBradesco c = conta.getCofres().get(i);
                System.out.println((i + 1) + " - " + c.getNomeCofre() + " (Saldo: R$ " + c.getSaldoCofre() + ")");
            }

            int opcao = input.nextInt();
            input.nextLine();

            int indice = opcao - 1;

            if (indice >= 0 && indice < conta.getCofres().size()) {
                CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                System.out.println("\nNome: " + cofreSelecionado.getNomeCofre());
                System.out.println("Objetivo: " + cofreSelecionado.getObjetivoCofre());
                System.out.println("Saldo atual do cofre: R$ " + cofreSelecionado.getSaldoCofre() + "\n");

                System.out.println("Digite o valor que deseja depositar: ");
                float valorDeposito = input.nextFloat();
                input.nextLine();

                if (valorDeposito <= 0) {
                    System.out.println("O valor do depósito deve ser maior que zero!");
                } else if (conta.getSaldoApp() < valorDeposito) {
                    System.out.println("Saldo insuficiente na conta principal!");
                } else {
                    float novoValorApp = conta.getSaldoApp() - valorDeposito;
                    conta.setSaldoApp(novoValorApp);

                    float novoSaldoCofre = cofreSelecionado.getSaldoCofre() + valorDeposito;
                    cofreSelecionado.setSaldoCofre(novoSaldoCofre);

                    System.out.println("\nDepósito realizado com sucesso!");
                    System.out.println("Novo saldo do cofre: R$ " + novoSaldoCofre);
                    System.out.println("Novo saldo no App: R$ " + novoValorApp);
                }
            } else {
                System.out.println("Opção inválida!");
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}