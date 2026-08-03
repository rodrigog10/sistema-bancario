package services;
import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.List;
import java.util.Scanner;

public class DrawAndSafes {





        public void cofres(Cliente cliente, List<cofreBradesco> cofres) {
            Bradesco conta = cliente.getConta();
            Scanner input = new Scanner(System.in);
            System.out.println("");
        }
        public void criarCofre(Cliente cliente, String nome, String objetivo, float valorCofre){
            Bradesco conta = cliente.getConta();
            cofreBradesco cofre = new cofreBradesco(nome, objetivo, valorCofre);
        }
}


