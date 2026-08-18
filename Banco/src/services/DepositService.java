package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

public class DepositService {

    public OperationResult depositar(Cliente cliente, int opcaoCofre, float valorDeposito) {
        Bradesco conta = cliente.getConta();

        // 1. Validação: A conta tem cofres?
        if (conta.getCofres().isEmpty()) {
            return OperationResult.erro("Você não tem cofrinhos registrados.");
        }

        // 2. Validação: A opção selecionada é válida no array?
        int indice = opcaoCofre - 1;
        if (indice < 0 || indice >= conta.getCofres().size()) {
            return OperationResult.erro("Opção inválida!");
        }

        // 3. Validação: O valor digitado é maior que zero?
        if (valorDeposito <= 0) {
            return OperationResult.erro("O valor do depósito deve ser maior que zero!");
        }

        // 4. Validação: O saldo no aplicativo é suficiente?
        if (conta.getSaldoApp() < valorDeposito) {
            return OperationResult.erro("Saldo insuficiente!");
        }


        CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

        // atualiza a conta principal
        float novoValorApp = conta.getSaldoApp() - valorDeposito;
        conta.setSaldoApp(novoValorApp);

        // atualiza o cofre real
        float novoSaldoCofre = cofreSelecionado.getSaldoCofre() + valorDeposito;
        cofreSelecionado.setSaldoCofre(novoSaldoCofre);

        // retorna o resultado e os novos valores caso a operação seja um sucesso.
        return OperationResult.sucesso("Depósito realizado com sucesso!",novoSaldoCofre, novoValorApp);
    }
}