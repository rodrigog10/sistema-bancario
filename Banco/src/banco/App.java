package banco;

import banco.dao.ClienteDAO;
import banco.domain.Cliente;
import banco.view.MenuApp;

import java.util.Scanner;

public class App {

        private final Scanner input = new Scanner(System.in);
        private final ClienteDAO clienteDAO = new ClienteDAO();
        private final MenuApp menuApp = new MenuApp();

        public void iniciarSistema() {
                boolean rodando = true;

                while (rodando) {
                        Cliente usuarioEncontrado = realizarLogin();

                        if (usuarioEncontrado != null) {
                                menuApp.exibirMenuPrincipal(usuarioEncontrado);
                        }
                }
        }

        private Cliente realizarLogin() {
                System.out.println("=== TELA DE LOGIN === \n");
                try {
                        System.out.print("Digite seu e-mail: ");
                        String emailDigitado = input.nextLine();

                        System.out.print("Digite sua senha: ");
                        int senhaDigitada = input.nextInt();
                        input.nextLine();

                        // verificação
                        Cliente cliente = clienteDAO.autenticar(emailDigitado, senhaDigitada);

                        if (cliente != null) {
                                System.out.println("\nBem-vindo(a), " + cliente.getNome() + "!");
                                return cliente;
                        } else {
                                System.out.println("E-mail ou senha incorretos, tente novamente.\n");
                        }

                } catch (Exception e) {
                        System.out.println("Erro ao processar login, tente novamente.\n");
                        input.nextLine();
                }
                return null;
        }
}