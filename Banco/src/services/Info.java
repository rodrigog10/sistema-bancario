package services;

import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.Scanner;

public class Info {

    public void informacoes(Cliente cliente) {
        Bradesco conta = cliente.getConta();

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("=== INFORMAÇÕES DA CONTA ===");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Saldo no App: R$ " + conta.getSaldoApp() + "\n");

            System.out.println("=== SEUS COFRINHOS ===");

            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não possui nenhum cofrinho cadastrado.\n");
            } else {
                for (int i = 0; i < conta.getCofres().size(); i++) {
                    cofreBradesco c = conta.getCofres().get(i);
                    System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + " | Saldo: R$ " + c.getSaldoCofre());
                }
                System.out.println();
            }

            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
        }
    }
}