package test;

import domain.Bradesco;
import domain.Cliente;

import java.util.List;
import java.util.Scanner;

public class ExecutionApp {

    public void loginApp(List<Cliente> clientes, List<Bradesco> contas) {
        App agencia = new App();
        Scanner input = new Scanner(System.in);
        boolean login = false;
        while (!login) {
            try {
                System.out.println("Digite seu email: ");
                String emailDigitado = input.nextLine();
                System.out.println("Digite sua senha: ");
                int senhaDigitada = input.nextInt();
                input.nextLine();


            } catch (Exception e) {
                System.out.println("Formato dos dados incorretos.");
                input.nextLine();
            }
        }

    }
}
