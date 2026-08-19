package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

public class CofreGestaoView {
    public static void exibirMenuGestaoCofre(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        for (int i = 0; i < conta.getCofres().size(); i++) {
            CofreBradesco c = conta.getCofres().get(i);
            System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + "\n - Objetivo: " + c.getObjetivoCofre() +"\n - Saldo: R$ " + c.getSaldoCofre());
        }
    }
}
