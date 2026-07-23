package domain;

public class Cliente {
    private String email;
    private int senha;



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
}