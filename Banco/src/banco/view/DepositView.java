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

            System.out.println("\n=== ÁREA DE DEPÓSITO ===\n");

            Bradesco conta = cliente.getConta();

            if(conta.getCofres().isEmpty()){
                System.out.println("\nVocê não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
                // o guard clause da UI: não afeta as boas práticas porque cuida apenas da experiência do usuário, enquanto a regra de negócio continua protegida e validada no service.
            }

            System.out.println("\nSaldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== Seus cofrinhos disponíveis: ===\n");


            CofreGestaoView.exibirMenuGestaoCofre(cliente);

            System.out.print("\nSelecione o cofrinho:");
            int opcaoCofre = input.nextInt();
            input.nextLine();

            System.out.print("\n Digite o valor que deseja depositar: R$ ");
            float valorDeposito = input.nextFloat();
            input.nextLine();


            OperationResult resultado = depositService.depositar(cliente, opcaoCofre, valorDeposito);


            if (resultado.isSucesso()) {
                System.out.println(" \n " + resultado.getMensagem() +" \n");

                System.out.println("\nValor do depósito efetuado: R$" + valorDeposito);
                System.out.println("Novo saldo do cofrinho: R$ " + resultado.getNovoSaldoCofre()+" \n");
                System.out.println("Saldo atual do aplicativo: R$ " + resultado.getNovoSaldoApp()+" \n");
                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();

            } else {
                System.out.println("\n " + resultado.getMensagem());
            }

        } catch (Exception e) {
            System.out.println("\n Ocorreu um erro ao processar a entrada. Verifique os dados digitados.");
            input.nextLine();
        }

    }
}