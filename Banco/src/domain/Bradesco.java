package domain;

import services.Deposit;

public class Bradesco {

    private float saldoBancario;
    private float cofrinhoPc;
    private float cofrinhoCasa;


        public void setSaldoBancario(float saldoBancario) {
            this.saldoBancario = saldoBancario;
        }
        public float getSaldoBancario() {
            return saldoBancario;
        }

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
    public void saldoTotal() {
            saldoBancario = saldoBancario + cofrinhoPc + cofrinhoCasa;
    }
}
