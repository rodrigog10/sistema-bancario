package banco.operations;

import banco.domain.Cliente;

public class OperationResult {
    private final boolean sucesso;
    private final String mensagem;
    private final float novoSaldoCofre;
    private final float novoSaldoApp;
    private final Cliente clienteRetornado; // Novo campo para guardar o cliente

    private OperationResult(boolean sucesso, String mensagem, float novoSaldoCofre, float novoSaldoApp, Cliente clienteRetornado) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.novoSaldoCofre = novoSaldoCofre;
        this.novoSaldoApp = novoSaldoApp;
        this.clienteRetornado = clienteRetornado;
    }

    // erro genérico
    public static OperationResult erro(String mensagem) {
        return new OperationResult(false, mensagem, 0, 0, null);
    }

    // sucesso sem alteração de valores
    public static OperationResult sucesso(String mensagem) {
        return new OperationResult(true, mensagem, 0, 0, null);
    }

    // sucesso com alteração de valores
    public static OperationResult sucesso(String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        return new OperationResult(true, mensagem, novoSaldoCofre, novoSaldoApp, null);
    }

    // sucesso retornando um cliente
    public static OperationResult sucesso(String mensagem, Cliente clienteRetornado) {
        return new OperationResult(true, mensagem, 0, 0, clienteRetornado);
    }


    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public float getNovoSaldoCofre() { return novoSaldoCofre; }
    public float getNovoSaldoApp() { return novoSaldoApp; }
    public Cliente getClienteRetornado() { return clienteRetornado; }
}