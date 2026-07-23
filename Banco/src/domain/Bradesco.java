package domain;

public class Bradesco {
    private float saldoApp = 10000;
    private float cofrinhoPc = 3500;
    private float cofrinhoCasa = 4500;
    private float saldoTotal;


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

    public float getSaldoTotal() {
        return saldoApp + cofrinhoPc + cofrinhoCasa;
    }
    public void setSaldoApp(float saldoApp) {
        this.saldoApp = saldoApp;
    }

    public float getSaldoApp() {
        return  saldoApp;
    }
}
