package banco.services;

import banco.dao.ContaBradescoDAO;
import banco.domain.Cliente;
import banco.operations.OperationResult;

import java.util.List;

public class TransferService {




    public OperationResult buscarDestinatarioDAO (String contaEscolhida, Cliente remetente){
        
        
        //aqui, inicialmente devo verificar se o remetente não está enviando para sí mesmo
        
        if (contaEscolhida.equals(remetente.getEmail())) {
            return OperationResult.erro("Você não pode enviar dinheiro para sí mesmo.");
        }
        
        
        ContaBradescoDAO contaBradescoDAO = new ContaBradescoDAO();
        Cliente contaDestinatario = contaBradescoDAO.buscarDestinatario(contaEscolhida);

            if (contaDestinatario != null) {
                return OperationResult.sucesso("Usuário encontrado: " + contaDestinatario.getNome(), contaDestinatario);
            }

            return OperationResult.erro("Usuário não encontrado.");
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


}