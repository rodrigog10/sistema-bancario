package banco.view.cofreView;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;
import banco.services.cofreServices.DepositCofreService;

import java.util.List;
import java.util.Scanner;

public class DepositCofreView {

    private final Scanner input = new Scanner(System.in);
    private final DepositCofreService depositService = new DepositCofreService();
    private final CofreDAO cofreDAO = new CofreDAO();

    public void exibirMenuDeposito(Cliente cliente, CofreBradesco cofreSelecionado, int opcaoCofre) {
        try {
            System.out.println("     Área de depósito\n");

            Bradesco conta = cliente.getConta();
            float saldoApp = cliente.getConta().getSaldoApp();
            List<CofreBradesco> cofres = cofreDAO.buscarCofres(conta.getId());

            if (cofres.isEmpty()) {
                System.out.println("\nVocê não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("Saldo disponível no App: R$ " + saldoApp+"\n");

            System.out.println("Digite o valor que deseja depositar: ");
            System.out.print("> ");
            float valorDeposito = input.nextFloat();
            input.nextLine();

            OperationResult resultado = depositService.depositar(cliente, cofreSelecionado, opcaoCofre, valorDeposito);

            if (resultado.isSucesso()) {
                System.out.println("\n" + resultado.getMensagem()+"\n");
                System.out.println("Valor do depósito efetuado: R$ " + valorDeposito + "\n");
                System.out.println("Novo saldo do cofrinho: R$ " + resultado.getNovoSaldoCofre());
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