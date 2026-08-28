package banco.connection;

import java.util.Scanner;
import banco.dao.ClienteDAO;
import banco.domain.Cliente;

public class TestLogin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("=== TELA DE LOGIN ===");

        System.out.print("Digite seu e-mail: ");
        String emailDigitado = scanner.nextLine();

        System.out.print("Digite sua senha (número): ");
        int senhaDigitada = scanner.nextInt();

        System.out.println("\nCarregando...");

        // Chama o método autenticar
        Cliente clienteLogado = clienteDAO.autenticar(emailDigitado, senhaDigitada);

        // Validação da resposta
        if (clienteLogado != null) {
            System.out.println("\n✅ LOGIN REALIZADO COM SUCESSO!");
            System.out.println("Bem-vindo(a), " + clienteLogado.getNome() + "!");
        } else {
            System.out.println("\n❌ FALHA NO LOGIN!");
            System.out.println("E-mail ou senha incorretos.");
        }

        scanner.close();
    }
}