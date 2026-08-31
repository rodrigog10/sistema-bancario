package banco.domain;

public class CofreBradesco {
    private int id; // Novo atributo para guardar o ID do banco
    private String nomeCofre;
    private String objetivoCofre;
    private float saldoCofre;

    // Construtor usado quando você busca do banco (já tem ID)
    public CofreBradesco(int id, String nomeCofre, String objetivoCofre, float saldoCofre) {
        this.id = id;
        this.nomeCofre = nomeCofre;
        this.objetivoCofre = objetivoCofre;
        this.saldoCofre = saldoCofre;
    }

    // Construtor usado quando o usuário cria um cofre novo na tela (ainda não tem ID no banco)
    public CofreBradesco(String nomeCofre, String objetivoCofre, float saldoCofre) {
        this.nomeCofre = nomeCofre;
        this.objetivoCofre = objetivoCofre;
        this.saldoCofre = saldoCofre;
    }

    // Getter e Setter para o ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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