package banco.view; // Ajuste o pacote para banco.view se estiver na pasta view

import banco.domain.Cliente;

import java.util.Scanner;

public class MenuApp {


    private final Scanner input = new Scanner(System.in);
    private final DepositView depositView = new DepositView();
    private final AccountInfoView accountInfoView = new AccountInfoView();
    private final CofreView cofreView = new CofreView();
    private final TransferView transferView = new TransferView();
    private final WithdrawView withdrawView = new WithdrawView();



    public void exibirMenuPrincipal(Cliente cliente) {
        boolean noMenu = true;

        while (noMenu) {
            System.out.println("\n============================");
            System.out.println("   BEM VINDO AO BANCO  ");
            System.out.println("============================");

            float saldo = (cliente.getConta() != null) ? cliente.getConta().getSaldoApp() : 0.0f;

            System.out.println("Seu saldo: R$" + saldo + "\n");

            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Cofre");
            System.out.println("4 - Consultar Saldo e Perfil");
            System.out.println("5 - Transferência (PIX)");
            System.out.println("0 - Sair da Conta\n");
            System.out.println("============================");
            System.out.print("\nSelecione a opção desejada: ");

            try {
                int opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1 -> depositView.exibirMenuDeposito(cliente);
                    case 2 -> withdrawView.exibirMenuSaque(cliente);
                    case 3 -> cofreView.exibirMenuCofre(cliente);
                    case 4 -> accountInfoView.exibirMenuInfo(cliente);
                    case 5 -> transferView.exibirMenuTransfer(cliente, null);
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