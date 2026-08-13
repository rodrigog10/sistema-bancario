package view;

import domain.Bradesco;
import domain.CofreBradesco;

public class CofreViewUtils {

    public static void exibirListaCofres(Bradesco conta) {
        for (int i = 0; i < conta.getCofres().size(); i++) {
            CofreBradesco c = conta.getCofres().get(i);
            System.out.println((i + 1) + " - " + c.getNomeCofre() + " (Saldo: R$ " + c.getSaldoCofre() + ")");
        }
    }
}