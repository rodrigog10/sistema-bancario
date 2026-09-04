package banco.services;

import banco.dao.ClienteDAO;
import banco.dao.ContaBradescoDAO;
import banco.domain.Cliente;

import java.util.List;

public class TransferService {




    public Cliente buscarDestinatarioDAO(String contaEscolhida, Cliente remetente){
        ContaBradescoDAO contaBradescoDao = new ContaBradescoDAO();

        if (contaEscolhida == null || contaEscolhida.trim().isEmpty()){

        }

        int idContaDestinatario = contaBradescoDao.buscarDestinatario(contaEscolhida);

        if (idContaDestinatario == -1) {

        }


        return remetente;
    }

    // public void transferencia();




    public Cliente buscarDestinatario(String contaEscolhida, Cliente remetente, List<Cliente> clientes) {

        if (contaEscolhida == null || contaEscolhida.trim().isEmpty()) {
            return null;
        }







        for (Cliente cliente : clientes) {
            boolean chaveIsTrue = cliente.getCpf().equals(contaEscolhida) || cliente.getEmail().equalsIgnoreCase(contaEscolhida);
            boolean sameRemetente = cliente.getCpf().equals(remetente.getCpf());

            //
            if (chaveIsTrue && !sameRemetente) {
                return cliente;
            }
        }

        return null;
    }

    public OperationResult realizarTransferencia(Cliente remetente, Cliente destinatario, float valor) {
        if (valor <= 0) {
            return OperationResult.erro("O valor da transferência deve ser maior que zero.");
        }

        if (valor > remetente.getConta().getSaldoApp()) {
            return OperationResult.erro("Saldo insuficiente no aplicativo.");
        }

        float novoSaldoRemetente = remetente.getConta().getSaldoApp() - valor;
        float novoSaldoDestinatario = destinatario.getConta().getSaldoApp() + valor;

        remetente.getConta().setSaldoApp(novoSaldoRemetente);
        destinatario.getConta().setSaldoApp(novoSaldoDestinatario);

        return OperationResult.sucesso("Transferência concluída com sucesso!", 0, novoSaldoRemetente);
    }
}