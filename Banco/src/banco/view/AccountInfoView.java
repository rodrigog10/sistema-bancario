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
            System.out.println("Saldo no App: R$ " + conta.getSaldoApp() + "\n");

            System.out.println("\n=== SEUS COFRINHOS ===\n");

            if (conta.getCofres().isEmpty()) {
                System.out.println("\nVocê não possui nenhum cofrinho cadastrado.\n");
            } else {
                for (int i = 0; i < conta.getCofres().size(); i++) {
                    CofreBradesco c = conta.getCofres().get(i);
                    System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + " | Saldo: R$ " + c.getSaldoCofre());
                }
            }

            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}