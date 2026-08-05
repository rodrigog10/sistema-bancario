package services;

import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.Scanner;

public class Deposit {
    Scanner input = new Scanner(System.in);

    public void depositar(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        try {

            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não tem cofrinhos registrados.");
                System.out.println("Digite qualquer tecla para voltar ao menu");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("Selecione o cofrinho que deseja depositar: ");


            for (int i = 0; i < conta.getCofres().size(); i++) {
                cofreBradesco c = conta.getCofres().get(i);
                System.out.println((i + 1) + " - " + c.getNomeCofre());
            }

            int opcao = input.nextInt();
            input.nextLine();
            int indice = opcao - 1;


            if (indice >= 0 && indice < conta.getCofres().size()) {


                cofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                System.out.println("Nome: " + cofreSelecionado.getNomeCofre());
                System.out.println("Objetivo: " + cofreSelecionado.getObjetivoCofre());
                System.out.println("Valor Atual: R$ " + cofreSelecionado.getSaldoCofre() + "\n");

                System.out.println("Digite o valor que deseja depositar: ");
                float valorDeposito = input.nextFloat();

                // Verifica se tem saldo suficiente na conta principal
                if (conta.getSaldoApp() < valorDeposito) {
                    System.out.println("Saldo insuficiente na conta principal!");
                } else {
                    // Atualiza saldo da conta principal
                    float novoValorApp = conta.getSaldoApp() - valorDeposito;
                    conta.setSaldoApp(novoValorApp);

                    // Atualiza saldo do cofrinho
                    float novoSaldoCofre = cofreSelecionado.getSaldoCofre() + valorDeposito;
                    cofreSelecionado.setSaldoCofre(novoSaldoCofre);

                    System.out.println("\nPerfeito! O saldo do seu cofrinho foi atualizado.");
                    System.out.println("Novo saldo do cofre: R$ " + novoSaldoCofre);
                    System.out.println("Saldo restante no App: R$ " + novoValorApp + "\n");
                }
            } else {
                System.out.println("Opção inválida!");
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}