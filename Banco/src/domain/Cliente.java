package domain;



public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private int senha;
    private Bradesco conta;


    public Cliente(String nome, int idade, String cpf, String email, int senha, Bradesco conta ) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.conta = conta;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }


    public void setCliente(Cliente cliente) {

    }

    public void setConta(Bradesco conta) {
        this.conta = conta;
    }
    public Bradesco getConta() {
        return conta;
    }
}
