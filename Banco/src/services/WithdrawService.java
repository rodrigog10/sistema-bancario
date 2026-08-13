package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawService {
    public WithdrawResult sacar(Cliente cliente, int opcaoCofre, float valorSaque) {
        Scanner input = new Scanner(System.in);
        Bradesco conta = cliente.getConta();

            if (conta.getCofres().isEmpty()) {
                return WithdrawResult.erro("Você não possui cofrinhos registrados.");
            }
            int indice = opcaoCofre - 1;
            if (conta.getCofres().get(indice).getSaldoCofre() < valorSaque ) {
                return WithdrawResult.erro("Saldo insuficiente dentro do cofre!");
            }


        CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

        float novoSaldoApp = valorSaque + conta.getSaldoApp();
        float novoSaldoCofre = cofreSelecionado.getSaldoCofre() - valorSaque;

        conta.setSaldoApp(novoSaldoApp);
        cofreSelecionado.setSaldoCofre(novoSaldoCofre);

        return WithdrawResult.sucesso(novoSaldoCofre, novoSaldoApp);
    }
}