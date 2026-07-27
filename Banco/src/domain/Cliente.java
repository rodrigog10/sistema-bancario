package domain;

public class Cliente {
    private String nome = "José Rodrigo Bispo de Oliveira e Silva";
    private int idade = 18;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }
}