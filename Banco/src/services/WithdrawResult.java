package services;

public class WithdrawResult {
    private boolean sucesso;
    private String mensagem;
    private float novoSaldoCofre;
    private float novoSaldoApp;

    public WithdrawResult(boolean sucesso, String mensagem, float novoSaldoCofre, float novoSaldoApp) {
          this.sucesso = sucesso;
          this.mensagem = mensagem;
          this.novoSaldoCofre = novoSaldoCofre;
          this.novoSaldoApp = novoSaldoApp;

        }

        //métodos estáticos para erro e sucesso

    public static WithdrawResult erro(String mensagem) {
        return new WithdrawResult(false, mensagem, 0, 0);
    }

    public static WithdrawResult sucesso(float novoSaldoCofre, float novoSaldoApp) {
        return new WithdrawResult(true, "Saque realizado com sucesso!", novoSaldoCofre, novoSaldoApp);
    }



    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public float getNovoSaldoCofre() { return novoSaldoCofre; }
    public float getNovoSaldoApp() { return novoSaldoApp; }
}
