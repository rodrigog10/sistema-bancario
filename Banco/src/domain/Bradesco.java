package domain;

public class Bradesco {
    private float saldoApp;
    private float limiteEmprestimo;
    private float cofrinhoPc;
    private float cofrinhoCasa;

    public Bradesco() {
    }

    public Bradesco(float saldoApp, float limiteEmprestimo, float cofrinhoPc, float cofrinhoCasa) {
        this.saldoApp = saldoApp;
        this.limiteEmprestimo = limiteEmprestimo;
        this.cofrinhoPc = cofrinhoPc;
        this.cofrinhoCasa = cofrinhoCasa;
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

    public float getCofrinhoPc() {
        return cofrinhoPc;
    }

    public void setCofrinhoPc(float cofrinhoPc) {
        this.cofrinhoPc = cofrinhoPc;
    }

    public float getCofrinhoCasa() {
        return cofrinhoCasa;
    }

    public void setCofrinhoCasa(float cofrinhoCasa) {
        this.cofrinhoCasa = cofrinhoCasa;
    }

    public float getSaldoTotal() {
        return saldoApp + cofrinhoPc + cofrinhoCasa;
    }
}