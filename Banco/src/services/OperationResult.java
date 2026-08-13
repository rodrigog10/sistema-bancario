package services;

public class OperationResult {
    private boolean sucesso;
    private String mensagem;
    private float novoSaldoCofre;
    private float novoSaldoApp;

    // Construtor principal
    public OperationResult(boolean sucesso, String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.novoSaldoCofre = novoSaldoCofre;
        this.novoSaldoApp = novoSaldoApp;
    }

    // Método estático para ERROS: Recebe a mensagem dinâmica de acordo com a validação

    public static OperationResult erro(String mensagem) {
        return new OperationResult(false, mensagem, 0, 0);
    }

    // Método estático para SUCESSO: Usa a mensagem padrão de confirmação

    public static OperationResult sucesso(String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        return new OperationResult(true, mensagem, novoSaldoCofre, novoSaldoApp);
    }

    // Getters para a View conseguir ler as informações
    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public float getNovoSaldoCofre() { return novoSaldoCofre; }
    public float getNovoSaldoApp() { return novoSaldoApp; }

}