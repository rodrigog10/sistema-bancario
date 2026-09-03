package banco.view.cofreView;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;
import banco.services.cofreServices.WithdrawCofreService;
import banco.view.CofreGestaoView;

import java.util.List;
import java.util.Scanner;

public class WithdrawCofreView {
    private final CofreDAO cofreDAO = new CofreDAO();
    private final Scanner input = new Scanner(System.in);
    private final WithdrawCofreService withdrawService = new WithdrawCofreService();

    public void exibirMenuSaque(Cliente cliente, CofreBradesco cofreSelecionado, int opcaoCofre) {
        Bradesco conta = cliente.getConta();
        float saldoCofre = cofreSelecionado.getSaldoCofre();

        List<CofreBradesco> cofres = cofreDAO.buscarCofres(conta.getId());

        try {
            System.out.println("     Área de saque\n");
            if (cofres.isEmpty()) {
                System.out.println("\nVocê não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no cofrinho: R$ " + saldoCofre);

            System.out.print("Digite o valor que deseja sacar: R$ ");
            float valorSaque = input.nextFloat();
            input.nextLine();

            OperationResult resultado = withdrawService.sacar(cliente, cofreSelecionado, opcaoCofre, valorSaque);

            if (resultado.isSucesso()) {
            System.out.println("\n" + resultado.getMensagem() + "\n");
                System.out.println("Valor do saque efetuado: R$ " + valorSaque + "\n");
                System.out.println("Novo saldo do cofrinho: R$ " + resultado.getNovoSaldoCofre());

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