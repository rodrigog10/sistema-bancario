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
        Cliente clienteLogado = null;
        Bradesco contaLogada = null;
        while (!login) {
            try {
                System.out.println("Digite seu email: ");
                String emailDigitado = input.nextLine();
                System.out.println("Digite sua senha: ");
                int senhaDigitada = input.nextInt();
                input.nextLine();
                    for (int i = 0; i < clientes.size() && i < contas.size(); i++) {
                        if (clientes.get(i).getEmail().equals(emailDigitado) &&  clientes.get(i).getSenha()== (senhaDigitada)) {
                            clienteLogado = clientes.get(i);
                            contaLogada = contas.get(i);
                            login = true;
                        }
                        if (login) {
                            System.out.println("Bem vindo, " + clientes.get(i).getNome());
                            agencia.iniciar(clienteLogado, contaLogada);
                        }
                    } // AJUSTAR A LIGAÇÃO DOS DADOS


            } catch (Exception e) {
                System.out.println("Formato dos dados incorretos.");
                input.nextLine();
            }
        }

    }
}
