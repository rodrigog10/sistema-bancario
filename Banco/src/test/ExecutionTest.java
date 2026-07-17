package test;

import domain.Cliente;
import test.Agencia;
import java.util.Scanner;

public class ExecutionTest {


    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        Cliente cliente = new Cliente();
        Scanner input = new Scanner(System.in);



        boolean login = false;

        while (!login) {

            try {
                System.out.println("Digite seu email: ");
                String email = input.nextLine();
                System.out.println("Digite sua senha: ");
                int senha = input.nextInt();
                input.nextLine();

                if (email.equals("rodrigobisppo123@gmail.com") && senha == 1234 ) {
                    System.out.println("Login efetuado com sucesso.");
                    cliente.setEmail(email);
                    cliente.setSenha(senha);
                    login = true;

                } else  {
                    System.out.println("Senha ou Login incorreto, tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Formato dos dados incorretos.");
            }
        }
            agencia.iniciar(cliente);
    }
}
