package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.services.OperationResult;
import banco.services.DepositService;

import java.util.Scanner;

public class DepositView {

    private final Scanner input = new Scanner(System.in);
    private final DepositService depositService = new DepositService();

    public void exibirMenuDeposito(Cliente cliente) {
        try {
            System.out.println("=== ÁREA DE DEPÓSITO ===");

            Bradesco conta = cliente.getConta();

            if (conta.getCofres().isEmpty()) {
                System.out.println("\nVocê não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== Seus cofrinhos disponíveis: ===");

            CofreGestaoView.exibirMenuGestaoCofre(cliente);

            System.out.print("\nSelecione o cofrinho: ");
            int opcaoCofre = input.nextInt();

            System.out.print("Digite o valor que deseja depositar: R$ ");
            float valorDeposito = input.nextFloat();
            input.nextLine();

            OperationResult resultado = depositService.depositar(cliente, opcaoCofre, valorDeposito);

            if (resultado.isSucesso()) {
                System.out.println("\n" + resultado.getMensagem());
                System.out.println("Valor do depósito efetuado: R$ " + valorDeposito);
                System.out.println("Novo saldo do cofrinho: R$ " + resultado.getNovoSaldoCofre());
                System.out.println("Saldo atual do aplicativo: R$ " + resultado.getNovoSaldoApp());
                System.out.println("\nPressione ENTER para voltar ao menu...");
                input.nextLine();
            } else {
                System.out.println("\n" + resultado.getMensagem());
                System.out.println("\nPressione ENTER para voltar ao menu...");
                input.nextLine();
            }

        } catch (Exception e) {
            System.out.println("\nOcorreu um erro ao processar a entrada. Verifique os dados digitados.");
            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();
        }
    }
}