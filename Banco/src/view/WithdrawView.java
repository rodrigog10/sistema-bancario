package view;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import services.OperationResult;
import services.WithdrawService;

import java.util.Scanner;

public class WithdrawView {
    Scanner input = new Scanner(System.in);
    WithdrawService withdrawService = new WithdrawService();

    public void exibirMenuSaque(Cliente cliente) {
        try {
            Bradesco conta = cliente.getConta();



            if(conta.getCofres().isEmpty()){
                System.out.println("Você não tem cofrinhos disponíveis.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
                // Guard Clause da UI: não afeta as boas práticas porque cuida apenas da experiência do usuário, enquanto a regra de negócio continua protegida e validada no Service.
            }

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== Seus cofrinhos disponíveis: ===");

            CofreViewUtils.exibirListaCofres(conta);

            System.out.println("Selecione o cofrinho que deseja sacar: ");
            int opcaoCofre = input.nextInt();

            System.out.println("Digite o valor que deseja sacar: ");
            float valorSaque = input.nextFloat();

            OperationResult resultado = withdrawService.sacar(cliente, opcaoCofre, valorSaque);

            if (resultado.isSucesso()) {
                System.out.println(" \n " + resultado.getMensagem());

                System.out.println("Valor do saque efetuado: R$" + valorSaque+" \n");
                System.out.println("Novo saldo do cofrinho: R$ " + resultado.getNovoSaldoCofre()+" \n");
                System.out.println("Saldo atual do aplicativo: R$ " + resultado.getNovoSaldoApp());
                System.out.println("Aperte ENTER para voltar ao menu.");
                input.nextLine();

            } else {
                System.out.println(resultado.getMensagem());
            }


        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
        }
    }
}
