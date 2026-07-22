package domain;

public class Cliente {
    private String email;
    private int senha;
    private float saldo = 10000;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSaldo(float saldo) {
        if (saldo <= 0) {
            System.out.println("Valor inválido, tente novamente.");
            return;
        }
        this.saldo = saldo;
    }

    public float getSaldo() {
        return this.saldo;
    }


}