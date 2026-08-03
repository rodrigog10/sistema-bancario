package domain;

public class cofreBradesco {
    private String nomeCofre;
    private String objetivoCofre;
    private float saldoCofre;

    public cofreBradesco(String nomeCofre, String objetivoCofre, float saldoCofre) {
        this.nomeCofre = nomeCofre;
        this.objetivoCofre = objetivoCofre;
        this.saldoCofre = saldoCofre;
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