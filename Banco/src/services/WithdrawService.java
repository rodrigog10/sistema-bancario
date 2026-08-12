package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawService {
    public void sacar(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        Bradesco conta = cliente.getConta();

        try {
            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não tem nenhum cofrinho cadastrado.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("\n=== SEUS COFRINHOS ===");
            System.out.println("Selecione o cofrinho do qual deseja sacar:");

            for (int i = 0; i < conta.getCofres().size(); i++) {
                CofreBradesco cofre = conta.getCofres().get(i);
                System.out.println((i + 1) + " - " + cofre.getNomeCofre() + " (Saldo: R$ " + cofre.getSaldoCofre() + ")");
            }

            int opcao = input.nextInt();
            input.nextLine();

            int indice = opcao - 1;

            if (indice >= 0 && indice < conta.getCofres().size()) {
                CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                System.out.println("Digite o valor que deseja sacar:");
                float valor = input.nextFloat();
                input.nextLine();

                if (valor <= 0) {
                    System.out.println("O valor do saque deve ser maior que zero!");
                } else if (valor > cofreSelecionado.getSaldoCofre()) {
                    System.out.println("Saldo do cofrinho insuficiente!");
                    System.out.println("Saldo atual do cofrinho: R$ " + cofreSelecionado.getSaldoCofre());
                } else {
                    float novoSaldoApp = conta.getSaldoApp() + valor;
                    conta.setSaldoApp(novoSaldoApp);

                    float novoSaldoCofre = cofreSelecionado.getSaldoCofre() - valor;
                    cofreSelecionado.setSaldoCofre(novoSaldoCofre);

                    System.out.println("\nSaque do cofrinho realizado com sucesso!");
                    System.out.println("Novo saldo do cofrinho: R$ " + novoSaldoCofre);
                    System.out.println("Novo saldo no App: R$ " + novoSaldoApp);
                }
            } else {
                System.out.println("Opção inválida!");
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Digite apenas números.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}