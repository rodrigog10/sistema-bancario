package services;

public class DepositResult {
    private boolean sucesso;
    private String mensagem;
    private float novoSaldoCofre;
    private float novoSaldoApp;

    // Construtor principal
    public DepositResult(boolean sucesso, String mensagem, float novoSaldoCofre, float novoSaldoApp) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.novoSaldoCofre = novoSaldoCofre;
        this.novoSaldoApp = novoSaldoApp;
    }

    // Método estático para ERROS: Recebe a mensagem dinâmica de acordo com a validação

    public static DepositResult erro(String mensagem) {
        return new DepositResult(false, mensagem, 0, 0);
    }

    // Método estático para SUCESSO: Usa a mensagem padrão de confirmação
    public static DepositResult sucesso(float novoSaldoCofre, float novoSaldoApp) {
        return new DepositResult(true, "Depósito realizado com sucesso!", novoSaldoCofre, novoSaldoApp);
    }

    // Getters para a View conseguir ler as informações
    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public float getNovoSaldoCofre() { return novoSaldoCofre; }
    public float getNovoSaldoApp() { return novoSaldoApp; }
}