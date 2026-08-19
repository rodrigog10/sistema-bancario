package view;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

public class CofreGestaoView {
    public static void exibirMenuGestaoCofre(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        for (int i = 0; i < conta.getCofres().size(); i++) {
            CofreBradesco c = conta.getCofres().get(i);
            System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + " | Objetivo: " + c.getObjetivoCofre() +" | Saldo: R$ " + c.getSaldoCofre());
        }
    }
}
