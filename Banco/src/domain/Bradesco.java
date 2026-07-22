package domain;

import services.Deposit;

public class Bradesco {
    Deposit deposit = new Deposit();
    private float saldoBancario;


        public void setSaldoBancario(float saldoBancario) {
            this.saldoBancario = saldoBancario;
        }
        public float getSaldoBancario() {
            return saldoBancario;
        }

}
