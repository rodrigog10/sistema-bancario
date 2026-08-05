package test;

import domain.Cliente;
import domain.cofreBradesco;

import java.util.List;
import java.util.Scanner;

public class ExecutionApp {

    public void loginApp(List<Cliente> clientes, List<cofreBradesco> cofres) {
        App agencia = new App();
        Scanner input = new Scanner(System.in);
        boolean login = false;

        Cliente clienteLogado = null;
        boolean rodando = true;
        while (rodando) {
            login = false;
            Cliente clienteLogin = null;
            while (!login) {
                try {
                    System.out.println("Digite seu email: ");
                    String emailDigitado = input.nextLine();
                    System.out.println("Digite sua senha: ");
                    int senhaDigitada = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getEmail().equals(emailDigitado) && clientes.get(i).getSenha() == senhaDigitada) {
                            clienteLogado = clientes.get(i);
                            login = true;
                            break;
                        }
                    }
                    if (login) {
                        System.out.println("Bem vindo, " + clienteLogado.getNome());

                        agencia.iniciar(clienteLogado, clientes, cofres);
                    } else {
                        System.out.println("E-mail ou senha incorretos, tente novamente.\n");
                    }

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}