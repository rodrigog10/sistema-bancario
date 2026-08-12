package view;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import services.DepositResult;
import services.DepositService;

import java.util.Scanner;

public class DepositView {
    private Scanner input = new Scanner(System.in);
    private DepositService depositService = new DepositService();

    public void exibirMenuDeposito(Cliente cliente) {
        try {
            Bradesco conta = cliente.getConta();

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== SEUS COFRINHOS ===");

            // Desenha a lista de opções na tela
            for (int i = 0; i < conta.getCofres().size(); i++) {
                CofreBradesco c = conta.getCofres().get(i);
                System.out.println((i + 1) + " - " + c.getNomeCofre() + " (Saldo: R$ " + c.getSaldoCofre() + ")");
            }

            System.out.print("\nSelecione o cofrinho: ");
            int opcao = input.nextInt();
            input.nextLine(); // Limpa o buffer

            System.out.print("Digite o valor que deseja depositar: R$ ");
            float valorDeposito = input.nextFloat();
            input.nextLine(); // Limpa o buffer

            // Envia para o Service processar e recebe o Result
            DepositResult resultado = depositService.depositar(cliente, opcao, valorDeposito);

            // Apresenta a resposta da operação ao usuário
            if (resultado.isSucesso()) {
                System.out.println("\n " + resultado.getMensagem());
                System.out.println("Novo saldo do cofre: R$ " + resultado.getNovoSaldoCofre());
                System.out.println("Novo saldo no App: R$ " + resultado.getNovoSaldoApp());
            } else {
                System.out.println("\n " + resultado.getMensagem());
            }

        } catch (Exception e) {
            System.out.println("\n Ocorreu um erro ao processar a entrada. Verifique os dados digitados.");
            input.nextLine();
        }

        System.out.println("\nPressione ENTER para voltar ao menu...");
        input.nextLine();
    }
}