package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

import java.util.List;

public class CofreGestaoView {
    public static void exibirMenuGestaoCofre(List<CofreBradesco> cofres) {
        for (int i = 0; i < cofres.size(); i++) {
            CofreBradesco c = cofres.get(i);
            System.out.println("\n   "+(i + 1)+" Cofrinho: \n"+ "\n - Nome: " + c.getNomeCofre() + "\n - Objetivo: " + c.getObjetivoCofre() +"\n - Saldo: R$ " + c.getSaldoCofre() + "\n");
        }
    }
}
