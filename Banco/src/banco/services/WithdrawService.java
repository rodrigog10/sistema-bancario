package banco.services;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

public class WithdrawService {

    public OperationResult sacar(Cliente cliente, int opcaoCofre, float valorSaque) {

        if (valorSaque <= 0) {
            return OperationResult.erro("O valor do saque deve ser maior que zero.");
        }

        Bradesco conta = cliente.getConta();

        if (conta.getCofres().isEmpty()) {
            return OperationResult.erro("Você não possui cofrinhos registrados.");
        }

        int indice = opcaoCofre - 1;

        if (indice < 0 || indice >= conta.getCofres().size()) {
            return OperationResult.erro("Opção de cofre inválida.");
        }

        CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

        if (cofreSelecionado.getSaldoCofre() < valorSaque) {
            return OperationResult.erro("Saldo insuficiente dentro do cofre.");
        }

        float novoSaldoCofre = cofreSelecionado.getSaldoCofre() - valorSaque;
        float novoSaldoApp = conta.getSaldoApp() + valorSaque;

        cofreSelecionado.setSaldoCofre(novoSaldoCofre);
        conta.setSaldoApp(novoSaldoApp);

        return OperationResult.sucesso("Saque realizado com sucesso!", novoSaldoCofre, novoSaldoApp);
    }
}