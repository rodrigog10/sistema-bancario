package domain;

public class Cliente {
    private String email;
    private int senha;
    private float saldo = 10000;
    private float cofrinhoPc;
    private float cofrinhoCasa;

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

    // 💡 2. Mantendo tudo como float no Setter e Getter:
    public void setCofrinhoPc(float cofrinhoPc) {
        this.cofrinhoPc = cofrinhoPc;
    }

    public float getCofrinhoPc() {
        return this.cofrinhoPc;
    }
    public void setCofrinhoCasa(float cofrinhoCasa) {
        this.cofrinhoCasa = cofrinhoCasa;
    }
    public float getCofrinhoCasa() {
        return this.cofrinhoCasa;
    }
}