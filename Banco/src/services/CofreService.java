package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;



public class CofreService {

    public OperationResult alteraNomeCofre(Cliente cliente, CofreBradesco cofreSelecionado, int indice, String novoNome) {
        if (novoNome.equals("")) {
            return OperationResult.erro("O seu cofrinho precisa ter um nome. ");
        } else {
            return OperationResult.sucesso(null, 0, 0);
        }

    }

    public OperationResult gerenciamentoCofre (Cliente cliente, CofreBradesco cofreSelecionado, int indiceSelecao) {

        return null;
    }

}