package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

import java.util.Scanner;

public class AccountInfoView {

    public void exibirMenuInfo(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("=== INFORMAÇÕES DA CONTA ===");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Saldo no App: R$ " + conta.getSaldoApp());

            System.out.println("\n=== SEUS COFRINHOS ===");

            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não possui nenhum cofrinho cadastrado.");
            } else {
                for (int i = 0; i < conta.getCofres().size(); i++) {
                    CofreBradesco c = conta.getCofres().get(i);
                    System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() +" | Objetivo: " + c.getObjetivoCofre() + " | Saldo: R$ " + c.getSaldoCofre());
                }
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("\nUm erro inesperado aconteceu, tente novamente.");
            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();
        }
    }
}