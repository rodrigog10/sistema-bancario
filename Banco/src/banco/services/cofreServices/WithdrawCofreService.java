package banco.services.cofreServices;

import banco.dao.CofreDAO;
import banco.dao.ContaBradescoDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;

import java.util.List;

public class WithdrawCofreService {

    public OperationResult sacar(Cliente cliente, CofreBradesco cofreSelecionado, int opcaoCofre, float valorSaque) {

        CofreDAO cofreDAO =  new CofreDAO();
        ContaBradescoDAO contaBradescoDAO = new ContaBradescoDAO();
        int contaId = cliente.getConta().getId();
        int cofreId = cofreSelecionado.getId();
        List<CofreBradesco> cofres = cofreDAO.buscarCofres(cliente.getConta().getId());
        Bradesco conta = cliente.getConta();
        float saldoApp = conta.getSaldoApp();


        if (valorSaque <= 0) {
            return OperationResult.erro("O valor do saque deve ser maior que zero.");
        }

        if (cofres.isEmpty()) {
            return OperationResult.erro("Você não possui cofrinhos registrados.");
        }

        int indice = opcaoCofre - 1;
        if (indice < 0 || indice >= conta.getCofres().size()) {
            return OperationResult.erro("Opção de cofre inválida.");
        }

        if (cofreSelecionado.getSaldoCofre() < valorSaque) {
            return OperationResult.erro("Saldo insuficiente dentro do cofre.");
        }

        float saldoCofre = cofreSelecionado.getSaldoCofre();


        float novoSaldoApp = saldoApp + valorSaque;
        float novoSaldoCofre = saldoCofre - valorSaque;


        cofreDAO.sacarCofre(cofreId, novoSaldoCofre);
        contaBradescoDAO.atualizarSaldoApp(contaId, novoSaldoApp);


        cofreSelecionado.setSaldoCofre(novoSaldoCofre);
        conta.setSaldoApp(novoSaldoApp);

        return OperationResult.sucesso("Saque realizado com sucesso!", novoSaldoCofre, novoSaldoApp);
    }
}