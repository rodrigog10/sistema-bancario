package banco.services;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;



public class CofreService {

    CofreDAO cofreDAO = new CofreDAO();

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

        //cofreDAO.atualizarObjetivoCofre(cofre.getId(), novoObjetivo);
        //cofre.setObjetivoCofre(novoObjetivo);

        return OperationResult.sucesso("Seu objetivo foi alterado com sucesso! \n Novo objetivo: " + cofreSelecionado.getObjetivoCofre());
    }

    public OperationResult deletarCofre(Cliente cliente, CofreBradesco cofreSelecionado) {
        if (cofreSelecionado == null) {
            return OperationResult.erro("Cofrinho não encontrado.");
        }

        float saldoRetornado = cofreSelecionado.getSaldoCofre();
        float novoSaldoApp = saldoRetornado + cliente.getConta().getSaldoApp();

        cliente.getConta().setSaldoApp(novoSaldoApp);
        cliente.getConta().getCofres().remove(cofreSelecionado);

        return OperationResult.sucesso("Cofrinho deletado com sucesso. \n Saldo retornado: " + saldoRetornado, 0, novoSaldoApp);
    }

    public OperationResult optionYes(Cliente cliente, String novoNomeCofrinho, String novoObjetivoCofrinho, float valorDeposito) {
        Bradesco conta = cliente.getConta();

        if (valorDeposito <= 0) {
            return OperationResult.erro("O valor do depósito deve ser maior que zero.");
        }
        if (valorDeposito > conta.getSaldoApp()) {
            return OperationResult.erro("Saldo insuficiente no aplicativo para realizar este depósito.");
        }

        float novoSaldoApp = conta.getSaldoApp() - valorDeposito;
        conta.setSaldoApp(novoSaldoApp);

        CofreBradesco novoCofre = new CofreBradesco(novoNomeCofrinho, novoObjetivoCofrinho, valorDeposito);
        conta.getCofres().add(novoCofre);

        return OperationResult.sucesso("Seu cofrinho foi criado com sucesso!", valorDeposito, novoSaldoApp);
    }

    public OperationResult optionNo(Cliente cliente, String novoNomeCofrinho, String novoObjetivoCofrinho) {
        Bradesco conta = cliente.getConta();
        CofreBradesco novoCofre = new CofreBradesco(novoNomeCofrinho, novoObjetivoCofrinho, 0);

        conta.getCofres().add(novoCofre);
        return OperationResult.sucesso("Seu cofrinho foi criado com sucesso!", 0, conta.getSaldoApp());
    }
}