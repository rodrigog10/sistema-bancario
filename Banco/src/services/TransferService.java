package services;

import domain.Cliente;
import java.util.List;

public class TransferService {

    public OperationResult realizarTransferencia(Cliente remetente, String chaveDestino, float valor, List<Cliente> clientes) {
        // 1. Fail Fast: validação rápida do valor
        if (valor <= 0) {
            return OperationResult.erro("O valor da transferência deve ser maior que zero.");
        }

        if (valor > remetente.getConta().getSaldoApp()) {
            return OperationResult.erro("Saldo insuficiente no aplicativo.");
        }

        // 2. Busca o destinatário (faz o loop apenas 1 vez)
        Cliente destinatario = buscarCliente(chaveDestino, clientes);

        // 3. Validações do destinatário
        if (destinatario == null) {
            return OperationResult.erro("Destinatário não encontrado.");
        }

        if (destinatario.getCpf().equals(remetente.getCpf())) {
            return OperationResult.erro("Você não pode transferir dinheiro para si mesmo.");
        }

        // 4. Executa a transferência
        float novoSaldoRemetente = remetente.getConta().getSaldoApp() - valor;
        float novoSaldoDestinatario = destinatario.getConta().getSaldoApp() + valor;

        remetente.getConta().setSaldoApp(novoSaldoRemetente);
        destinatario.getConta().setSaldoApp(novoSaldoDestinatario);

        return OperationResult.sucesso("Transferência realizada com sucesso para " + destinatario.getNome() + "!", 0, novoSaldoRemetente);
    }

    // Método privado auxiliar: isola a lógica de busca e deixa o código limpo
    private Cliente buscarCliente(String chave, List<Cliente> clientes) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(chave) || c.getEmail().equalsIgnoreCase(chave)) {
                return c;
            }
        }
        return null; // Retorna null se não encontrar
    }
}