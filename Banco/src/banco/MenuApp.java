package banco.view; // Ajuste o pacote para banco.view se estiver na pasta view

import banco.domain.Cliente;
import banco.domain.CofreBradesco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {


    private final Scanner input = new Scanner(System.in);

    private final AccountInfoView accountInfoView = new AccountInfoView();
    private final CofreView cofreView = new CofreView();
    private final TransferView transferView = new TransferView();




    public void exibirMenuPrincipal(Cliente cliente) {
        boolean noMenu = true;

        while (noMenu) {
            System.out.println("\n============================");
            System.out.println("   BEM VINDO AO BANCO  ");
            System.out.println("============================");

            float saldo = (cliente.getConta() != null) ? cliente.getConta().getSaldoApp() : 0.0f;

            System.out.println("Seu saldo: R$" + saldo + "\n");


            System.out.println("1 - Transferência (PIX)");
            System.out.println("2 - Cofre");
            System.out.println("3 - Consultar Saldo e Perfil");
            System.out.println("0 - Sair da Conta\n");
            System.out.println("============================");
            System.out.println("\nSelecione a opção desejada: ");
            System.out.print("> ");

            try {
                int opcao = input.nextInt();
                input.nextLine();


                switch (opcao) {
//
                    case 1 -> transferView.exibirMenuTransfer(cliente, null);
                    case 2 -> cofreView.exibirMenuCofre(cliente);
                    case 3 -> accountInfoView.exibirMenuInfo(cliente);

                    case 0 -> {
                        System.out.println("Saindo da conta... Até logo!\n");
                        noMenu = false;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.\n");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida. Digite apenas números.\n");
                input.nextLine();
            }
        }
    }
}