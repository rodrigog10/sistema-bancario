package banco.view;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;
import banco.services.cofreServices.WithdrawService;

import java.util.List;
import java.util.Scanner;

public class WithdrawView {
    Bradesco conta = new Bradesco();
    private final CofreDAO cofreDAO = new CofreDAO();
    private final Scanner input = new Scanner(System.in);
    private final WithdrawService withdrawService = new WithdrawService();

    public void exibirMenuSaque(Cliente cliente) {
        List<CofreBradesco> cofres = cofreDAO.buscarCofres(conta.getId());
        try {
            System.out.println("=== ÁREA DE SAQUE ===");
            Bradesco conta = cliente.getConta();

            if (conta.getCofres().isEmpty()) {
                System.out.println("\nVocê não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== Seus cofrinhos disponíveis: ===");

            CofreGestaoView.exibirMenuGestaoCofre(cofres);

            System.out.print("\nSelecione o cofrinho que deseja sacar: ");
            int opcaoCofre = input.nextInt();

            System.out.print("Digite o valor que deseja sacar: R$ ");
            float valorSaque = input.nextFloat();
            input.nextLine();

            OperationResult resultado = withdrawService.sacar(cliente, opcaoCofre, valorSaque);

            if (resultado.isSucesso()) {
                System.out.println("\n" + resultado.getMensagem());
                System.out.println("Valor do saque efetuado: R$ " + valorSaque);
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
            System.out.println("\nUm erro inesperado aconteceu.");
            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();
        }
    }
}