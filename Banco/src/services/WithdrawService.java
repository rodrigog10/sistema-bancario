package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

public class WithdrawService {
    public OperationResult sacar(Cliente cliente, int opcaoCofre, float valorSaque) {
        Bradesco conta = cliente.getConta();

            if (conta.getCofres().isEmpty()) {
                return OperationResult.erro("Você não possui cofrinhos registrados.");
            }

            int indice = opcaoCofre - 1;

            if (indice < 0 || indice >= conta.getCofres().size()) {
                return OperationResult.erro("Opção de cofre inválida.");
            }

            if (conta.getCofres().get(indice).getSaldoCofre() < valorSaque ) {
                return OperationResult.erro("Saldo insuficiente dentro do cofre.");
            }

            if (valorSaque < 0) {
                return OperationResult.erro("O valor do saque deve ser maior que zero.");
            }


        CofreBradesco cofreSelecionado = conta.getCofres().get(indice);


        float novoSaldoCofre = cofreSelecionado.getSaldoCofre() - valorSaque;
        float novoSaldoApp = valorSaque + conta.getSaldoApp();


        conta.setSaldoApp(novoSaldoApp);
        cofreSelecionado.setSaldoCofre(novoSaldoCofre);

        return OperationResult.sucesso("Saque realizado com sucesso! \n",novoSaldoCofre, novoSaldoApp);
    }
}