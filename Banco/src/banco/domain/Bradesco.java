package banco.domain;

import java.util.ArrayList;
import java.util.List;

public class Bradesco {
    private float saldoApp;
    private List<CofreBradesco> cofres = new ArrayList<>();
    private int id;

    public Bradesco() {
    }

    public Bradesco(float saldoApp, List<CofreBradesco> cofres) {
        this.saldoApp = saldoApp;
        this.cofres = cofres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public float getSaldoApp() {
        return saldoApp;
    }

    public void setSaldoApp(float saldoApp) {
        this.saldoApp = saldoApp;
    }

    public List<CofreBradesco> getCofres() {
        return cofres;
    }

}