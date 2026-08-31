package banco.domain;

public class CofreBradesco {
    private int id;
    private int contaId;
    private String nomeCofre;
    private String objetivoCofre;
    private float saldoCofre;

    // 1. Construtor usado quando você busca do banco (vem id, contaId, nome, objetivo, saldo)
    public CofreBradesco(int id, int contaId, String nomeCofre, String objetivoCofre, float saldoCofre) {
        this.id = id;
        this.contaId = contaId;
        this.nomeCofre = nomeCofre;
        this.objetivoCofre = objetivoCofre;
        this.saldoCofre = saldoCofre;
    }

    // 2. Construtor usado quando o usuário cria um cofre novo na tela (ainda não tem ID do banco)
    public CofreBradesco(int contaId, String nomeCofre, String objetivoCofre, float saldoCofre) {
        this.contaId = contaId;
        this.nomeCofre = nomeCofre;
        this.objetivoCofre = objetivoCofre;
        this.saldoCofre = saldoCofre;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContaId() {
        return contaId;
    }

    public String getNomeCofre() {
        return nomeCofre;
    }

    public void setNomeCofre(String nomeCofre) {
        this.nomeCofre = nomeCofre;
    }

    public String getObjetivoCofre() {
        return objetivoCofre;
    }

    public void setObjetivoCofre(String objetivoCofre) {
        this.objetivoCofre = objetivoCofre;
    }

    public float getSaldoCofre() {
        return saldoCofre;
    }

    public void setSaldoCofre(float saldoCofre) {
        this.saldoCofre = saldoCofre;
    }
}