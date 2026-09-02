package banco.view;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

import java.util.List;
import java.util.Scanner;

public class AccountInfoView {

    public void exibirMenuInfo(Cliente cliente) {

        CofreDAO cofreDAO =  new CofreDAO();
        Bradesco conta = cliente.getConta();
        List<CofreBradesco> cofres = cofreDAO.buscarCofres(conta.getId());


        CofreGestaoView cofreGestaoView =  new CofreGestaoView();


        Scanner input = new Scanner(System.in);

        try {
            System.out.println("=== INFORMAÇÕES DA CONTA ===");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Saldo no App: R$ " + conta.getSaldoApp());

            System.out.println("\n=== SEUS COFRINHOS ===");

            if (cofres.isEmpty()) {
                System.out.println("Você não possui nenhum cofrinho cadastrado.");
            } else {
                cofreGestaoView.exibirMenuGestaoCofre(cofres);
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("\nUm erro inesperado aconteceu, tente novamente.");
            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();
        }
    }
}