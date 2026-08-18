package services;

import domain.Cliente;
import domain.CofreBradesco;

public class CofreService {

    public OperationResult alteraNomeCofre(CofreBradesco cofre, String novoNome) {

        // para o nome:

        if (novoNome == null || novoNome.trim().isEmpty()) {
            return OperationResult.erro("O seu cofrinho precisa ter um nome.");
        } else {
            cofre.setNomeCofre(novoNome);
            return OperationResult.sucessoNome("Nome do cofrinho alterado com sucesso para: " + cofre.getNomeCofre());
        }
    }



    // para o objetivo:

    public OperationResult alterarObjetivo(CofreBradesco cofre, String novoObjetivo) {

            if (novoObjetivo == null || novoObjetivo.trim().isEmpty()) {
                return OperationResult.erro("O seu cofrinho deve ter um objetivo.");
            }
                cofre.setObjetivoCofre(novoObjetivo);
                    return OperationResult.sucessoObjetivo("Seu objetivo foi alterado com sucesso! \n Novo objetivo: " + cofre.getObjetivoCofre());

    }




    public OperationResult deletarCofre(Cliente cliente , CofreBradesco cofreSelecionado) {
       if (cofreSelecionado == null) {
           return OperationResult.erro("Cofrinho não encontrado.");

       }

           float saldoRetornado = cofreSelecionado.getSaldoCofre();
           float novoSaldoApp = saldoRetornado + cliente.getConta().getSaldoApp();
           cliente.getConta().setSaldoApp(novoSaldoApp);

            cliente.getConta().getCofres().remove(cofreSelecionado);

            return OperationResult.sucessoDeleteCofre("Cofrinho deletado com sucesso. \n Saldo retornado: " + saldoRetornado, novoSaldoApp);
    }
}