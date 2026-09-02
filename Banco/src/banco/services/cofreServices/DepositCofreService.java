package banco.services.cofreServices;

import banco.dao.CofreDAO;
import banco.dao.ContaBradescoDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;

public class DepositCofreService {

    public OperationResult depositar(Cliente cliente, CofreBradesco cofreSelecionado, int opcaoCofre, float valorDeposito) {
        CofreDAO cofreDAO =  new CofreDAO();
        ContaBradescoDAO contaBradescoDAO = new ContaBradescoDAO();

        int contaId = cliente.getConta().getId();
        int cofreId = cofreSelecionado.getId();

        Bradesco conta = cliente.getConta();
        float saldoApp = conta.getSaldoApp();

        if (valorDeposito <= 0) {
            return OperationResult.erro("O valor do depósito deve ser maior que zero.");
        }
        if (cofreSelecionado == null || cofreSelecionado.getId() == 0) {
            return OperationResult.erro("Você não tem cofrinhos registrados.");
        }


        int indice = opcaoCofre - 1;
        if (indice < 0 || indice >= cliente.getConta().getCofres().size()) {
            return OperationResult.erro("Opção inválida!");
        }


        if (saldoApp < valorDeposito) {
            return OperationResult.erro("Saldo insuficiente!");
        }

        float novoSaldoApp = saldoApp - valorDeposito;
        float novoSaldoCofre = cofreSelecionado.getSaldoCofre() + valorDeposito;

        //  Atualização no banco de dados:
            cofreDAO.depositarCofre(cofreId, novoSaldoCofre);
            contaBradescoDAO.atualizarSaldoApp(contaId, novoSaldoApp);
        //--------------------------------------


        //  atualiza o saldo do aplicativo na memória
            conta.setSaldoApp(novoSaldoApp);

        // atualiza o saldo do cofre na memória
            cofreSelecionado.setSaldoCofre(novoSaldoCofre);


        return OperationResult.sucesso("Depósito realizado com sucesso!", novoSaldoCofre, novoSaldoApp);
    }
}