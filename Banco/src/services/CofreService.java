package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

public class CofreService {

    public OperationResult alteraNomeCofre(CofreBradesco cofre, String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            return OperationResult.erro("O seu cofrinho precisa ter um nome.");
        }

        cofre.setNomeCofre(novoNome);
        return OperationResult.sucesso("Nome do cofrinho alterado com sucesso para: " + cofre.getNomeCofre());
    }

    public OperationResult alterarObjetivo(CofreBradesco cofre, String novoObjetivo) {
        if (novoObjetivo == null || novoObjetivo.trim().isEmpty()) {
            return OperationResult.erro("O seu cofrinho deve ter um objetivo.");
        }

        cofre.setObjetivoCofre(novoObjetivo);
        return OperationResult.sucesso("Seu objetivo foi alterado com sucesso! \n Novo objetivo: " + cofre.getObjetivoCofre());
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