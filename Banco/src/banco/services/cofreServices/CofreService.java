package banco.services.cofreServices;

import banco.dao.CofreDAO;
import banco.dao.ContaBradescoDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.OperationResult;


public class CofreService {

    CofreDAO cofreDAO = new CofreDAO();
    ContaBradescoDAO contaBradescoDAO = new ContaBradescoDAO();

    public OperationResult alteraNomeCofre(String novoNome, CofreBradesco cofreSelecionado) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            return OperationResult.erro("O seu cofrinho precisa ter um nome.");
        }
        cofreDAO.atualizarNomeCofre(novoNome, cofreSelecionado.getId());
        cofreSelecionado.setNomeCofre(novoNome);

        return OperationResult.sucesso("Nome do cofrinho alterado com sucesso para: " + cofreSelecionado.getNomeCofre());
    }

    public OperationResult alterarObjetivo(CofreBradesco cofreSelecionado, String novoObjetivo) {
        if (novoObjetivo == null || novoObjetivo.trim().isEmpty()) {
            return OperationResult.erro("O seu cofrinho deve ter um objetivo.");
        }

        cofreDAO.atualizarObjetivoCofre(novoObjetivo, cofreSelecionado.getId());
        cofreSelecionado.setObjetivoCofre(novoObjetivo);

        return OperationResult.sucesso("Seu objetivo foi alterado com sucesso! \n Novo objetivo: " + cofreSelecionado.getObjetivoCofre());
    }

    public OperationResult deletarCofre(CofreBradesco cofreSelecionado, Cliente cliente) {
        if (cofreSelecionado == null || cofreSelecionado.getId() == 0) {
            return OperationResult.erro("Cofrinho não encontrado.");
        }

        int cofreId = cofreSelecionado.getId();
        int contaId = cliente.getConta().getId();

        float saldoRetornado = cofreSelecionado.getSaldoCofre();
        float novoSaldoApp = cliente.getConta().getSaldoApp() + saldoRetornado;

        //atualiza no banco
        contaBradescoDAO.atualizarSaldoApp(contaId, novoSaldoApp);
        cofreDAO.deletarCofre(cofreId);

        //atualiza na memória
        cliente.getConta().setSaldoApp(novoSaldoApp);
        cliente.getConta().getCofres().remove(cofreSelecionado);

        return OperationResult.sucesso("Cofrinho deletado com sucesso. \n Saldo retornado: R$ " + saldoRetornado, 0, novoSaldoApp);
    }


    public OperationResult optionComSaldo(Bradesco conta, int contaId, float saldoApp, String novoNomeCofrinho, String novoObjetivoCofrinho, float valorDeposito){

        if (valorDeposito <= 0) {
            return OperationResult.erro("O valor do depósito deve ser maior que zero.");
        }
        if (valorDeposito > saldoApp) {
            return OperationResult.erro("Saldo insuficiente no aplicativo para realizar este depósito.");
        }

        CofreBradesco novoCofreComSaldo = new CofreBradesco(contaId, novoNomeCofrinho, novoObjetivoCofrinho, valorDeposito);
        cofreDAO.criarCofreComSaldo(novoCofreComSaldo);
           conta.getCofres().add(novoCofreComSaldo);
        float novoSaldoApp = conta.getSaldoApp() - valorDeposito;

        //atualizando no banco e na memória.
        contaBradescoDAO.atualizarSaldoApp(contaId, novoSaldoApp);
        conta.setSaldoApp(novoSaldoApp);

        return OperationResult.sucesso("Seu cofrinho foi criado com sucesso! \n", valorDeposito, novoSaldoApp);
    }

    public OperationResult optionSemSaldo(Bradesco conta, int contaId, String novoNomeCofrinho, String novoObjetivoCofrinho) {

        CofreBradesco novoCofreSemSaldo = new CofreBradesco(contaId, novoNomeCofrinho, novoObjetivoCofrinho, 0);

        cofreDAO.criarCofreSemSaldo(novoCofreSemSaldo);
        conta.getCofres().add(novoCofreSemSaldo);

        return OperationResult.sucesso("Seu cofrinho foi criado com sucesso!", 0, 0);
    }
}