package banco;

import banco.dao.ClienteDAO;
import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.view.MenuApp;

import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner input = new Scanner(System.in);
    private final ClienteDAO clienteDAO = new ClienteDAO();
    CofreDAO cofreDAO = new CofreDAO();
    private final MenuApp menuApp = new MenuApp();

    public void iniciarSistema() {
        boolean rodando = true;

        while (rodando) {
            Cliente usuarioLogado = realizarLogin();

            if (usuarioLogado != null) {
                menuApp.exibirMenuPrincipal(usuarioLogado);
            }
        }
    }

    private Cliente realizarLogin() {
        System.out.println("=== TELA DE LOGIN === \n");
        try {
            System.out.println("Digite seu e-mail: ");
            System.out.print("> ");
            String emailDigitado = input.nextLine();

            System.out.println("Digite sua senha: ");
            System.out.print("> ");
            int senhaDigitada = input.nextInt();
            input.nextLine();

            // verificação
            Cliente cliente = clienteDAO.autenticar(emailDigitado, senhaDigitada);

            if (cliente != null) {
                System.out.println("\nBem-vindo(a), " + cliente.getNome() + "!");


                List<CofreBradesco> cofres = cofreDAO.buscarCofres(cliente.getConta().getId());
                cliente.getConta().setCofres(cofres);

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