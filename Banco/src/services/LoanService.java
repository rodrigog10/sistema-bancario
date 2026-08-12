package services;

import domain.Bradesco;
import domain.Cliente;
import java.util.Scanner;

public class LoanService {

    public void emprestimo(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Limite de empréstimo disponível: R$ " + conta.getLimiteEmprestimo());
            System.out.println("Digite o valor que deseja resgatar: ");
            float valor = input.nextFloat();
            input.nextLine();

            if (valor <= 0) {
                System.out.println("Valor inválido! O valor deve ser maior que zero.");
            } else if (valor > conta.getLimiteEmprestimo()) {
                System.out.println("O valor digitado excede o seu limite disponível de R$ " + conta.getLimiteEmprestimo());
            } else {
                float novoLimite = conta.getLimiteEmprestimo() - valor;
                conta.setLimiteEmprestimo(novoLimite);

                float novoSaldoApp = conta.getSaldoApp() + valor;
                conta.setSaldoApp(novoSaldoApp);

                System.out.println("\nEmpréstimo de R$ " + valor + " creditado com sucesso!");
                System.out.println("Novo saldo no App: R$ " + novoSaldoApp);
                System.out.println("Limite de empréstimo restante: R$ " + novoLimite);
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}