package banco;

import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.view.*;

import java.util.List;
import java.util.Scanner;

public class App {

        private final Scanner input = new Scanner(System.in);


        private final DepositView depositView = new DepositView();
        private final AccountInfoView accountInfoView = new AccountInfoView();
        private final CofreView cofreView = new CofreView();
        private final TransferView transferView = new TransferView();
        private final WithdrawView withdrawView = new WithdrawView();

        public void iniciarSistema(List<Cliente> clientes, List<CofreBradesco> cofres) {
                boolean rodando = true;

                while (rodando) {
                        Cliente clienteLogado = realizarLogin(clientes);

                        if (clienteLogado != null) {
                                exibirMenuPrincipal(clienteLogado, clientes, cofres);
                        }
                }
        }

        private Cliente realizarLogin(List<Cliente> clientes) {
                System.out.println("=== TELA DE LOGIN ===");
                try {
                        System.out.print("Digite seu e-mail: ");
                        String emailDigitado = input.nextLine();

                        System.out.print("Digite sua senha: ");
                        int senhaDigitada = input.nextInt();
                        input.nextLine(); // Limpa buffer

                        for (Cliente cliente : clientes) {
                                if (cliente.getEmail().equalsIgnoreCase(emailDigitado) && cliente.getSenha() == senhaDigitada) {
                                        System.out.println("\nBem-vindo(a), " + cliente.getNome() + "!");
                                        return cliente;
                                }
                        }

                        System.out.println("E-mail ou senha incorretos, tente novamente.\n");
                } catch (Exception e) {
                        System.out.println("Erro ao processar login, tente novamente.\n");
                        input.nextLine(); // Limpa o buffer de erro do Scanner
                }
                return null;
        }

        private void exibirMenuPrincipal(Cliente cliente, List<Cliente> clientes, List<CofreBradesco> cofres) {
                boolean noMenu = true;

                while (noMenu) {
                        System.out.println("\n============================");
                        System.out.println("   BEM VINDO AO BANCO  ");
                        System.out.println("============================");
                        System.out.println("Seu saldo: R$" + cliente.getConta().getSaldoApp() + "\n");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Sacar");
                        System.out.println("3 - Cofre");
                        System.out.println("4 - Consultar Saldo e Perfil");
                        System.out.println("5 - Transferência (PIX)");
                        System.out.println("0 - Sair da Conta\n");
                        System.out.println("============================");
                        System.out.print("Selecione a opção desejada: ");

                        try {
                                int opcao = input.nextInt();
                                input.nextLine();

                                switch (opcao) {
                                        case 1 -> depositView.exibirMenuDeposito(cliente);
                                        case 2 -> withdrawView.exibirMenuSaque(cliente);
                                        case 3 -> cofreView.exibirMenuCofre(cliente);
                                        case 4 -> accountInfoView.exibirMenuInfo(cliente);
                                        case 5 -> transferView.exibirMenuTransfer(cliente, clientes);
                                        case 0 -> {
                                                System.out.println("Saindo da conta... Até logo!\n");
                                                noMenu = false; // volta para o loop de Login (proposital)
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