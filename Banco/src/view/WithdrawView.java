package view;
import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import services.WithdrawResult;
import services.WithdrawService;

import java.util.Scanner;

public class WithdrawView {
    Scanner input = new Scanner(System.in);
    WithdrawService withdrawService = new WithdrawService();
    public void exibirMenuSaque(Cliente cliente) {
        try {
            Bradesco conta = cliente.getConta();

            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("\n=== SEUS COFRINHOS ===");

            // Desenha a lista de opções na tela
            for (int i = 0; i < conta.getCofres().size(); i++) {
                CofreBradesco c = conta.getCofres().get(i);
                System.out.println((i + 1) + " - " + c.getNomeCofre() + " (Saldo: R$ " + c.getSaldoCofre() + ")");
            }
            System.out.println("Selecione o cofrinho que deseja sacar: ");
            int opcaoCofre =  input.nextInt();

            System.out.println("Digite o valor que deseja sacar: ");
            float valorSaque =   input.nextFloat();

            WithdrawResult resultado = withdrawService.sacar(cliente, opcaoCofre, valorSaque);

            if (resultado.isSucesso()) {

            }



        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
        }
    }
}
