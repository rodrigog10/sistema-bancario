package domain;

import java.util.ArrayList;
import java.util.List;

public class Bradesco {
    private float saldoApp;
    private float limiteEmprestimo;
    private List<CofreBradesco> cofres = new ArrayList<>();

    public Bradesco() {
    }

    public Bradesco(float saldoApp, float limiteEmprestimo, List<CofreBradesco> cofres) {
        this.saldoApp = saldoApp;
        this.limiteEmprestimo = limiteEmprestimo;
        this.cofres = cofres;
    }


    public float getSaldoApp() {
        return saldoApp;
    }

    public void setSaldoApp(float saldoApp) {
        this.saldoApp = saldoApp;
    }

    public void setLimiteEmprestimo(float limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public float getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setCofres(List<CofreBradesco> cofres) {
        this.cofres = cofres;
    }
    public List<CofreBradesco> getCofres() {
        return cofres;
    }

}