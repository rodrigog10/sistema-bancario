package banco.services;

public class OperationResult {
    private final boolean sucesso;
    private final String mensagem;
    private final float novoSaldoCofre;
    private final float novoSaldoApp;

    private OperationResult(boolean sucesso, String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.novoSaldoCofre = novoSaldoCofre;
        this.novoSaldoApp = novoSaldoApp;
    }

    // erro genérico
    public static OperationResult erro(String mensagem) {
        return new OperationResult(false, mensagem, 0, 0);
    }

    // sucesso sem alteração de valores
    public static OperationResult sucesso(String mensagem) {
        return new OperationResult(true, mensagem, 0, 0);
    }

    // sucesso com alteração de valores
    public static OperationResult sucesso(String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        return new OperationResult(true, mensagem, novoSaldoCofre, novoSaldoApp);
    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public float getNovoSaldoCofre() { return novoSaldoCofre; }
    public float getNovoSaldoApp() { return novoSaldoApp; }
}