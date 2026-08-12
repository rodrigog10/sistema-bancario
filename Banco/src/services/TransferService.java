package services;

import domain.Bradesco;
import domain.Cliente;
import java.util.List;
import java.util.Scanner;

public class TransferService {
    public void transferir(Cliente remetente, List<Cliente> clientes) {
        Bradesco contaRemetente = remetente.getConta();
        Cliente clienteEncontrado = null;
        boolean clientAcess = false;
        Scanner input = new Scanner(System.in);
        float valor = 0;

        try {
            System.out.println("Digite o e-mail ou CPF do destinatário: ");
            String contaDigitada = input.nextLine();

            for (int i = 0; i < clientes.size(); i++) {
                Cliente candidato = clientes.get(i);

                if (candidato.getEmail().equals(contaDigitada) || candidato.getCpf().equals(contaDigitada)) {


                    if (candidato.getCpf().equals(remetente.getCpf())) {
                        System.out.println("\nOperação inválida: Você não pode transferir dinheiro para a sua própria conta!");
                        System.out.println("Pressione ENTER para voltar ao menu...");
                        input.nextLine();
                        return;
                    }

                    clientAcess = true;
                    clienteEncontrado = candidato;
                    break;
                }
            }

            if (clientAcess) {
                System.out.println("Digite o valor a ser transferido para " + clienteEncontrado.getNome() + ":");
                valor = input.nextFloat();
                input.nextLine();

                if (valor <= 0) {
                    System.out.println("O valor da transferência deve ser maior que zero!");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                } else if (contaRemetente.getSaldoApp() < valor) {
                    System.out.println("Saldo insuficiente na conta principal!");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                } else {
                    Bradesco contaDestinatario = clienteEncontrado.getConta();
                    float novoSaldoQuemEnvia = contaRemetente.getSaldoApp() - valor;
                    contaRemetente.setSaldoApp(novoSaldoQuemEnvia);

                    contaDestinatario.setSaldoApp(contaDestinatario.getSaldoApp() + valor);

                    System.out.println("\nTransferência de R$ " + valor + " para " + clienteEncontrado.getNome() + " realizada com sucesso!");
                    System.out.println("Saldo restante no App: R$ " + novoSaldoQuemEnvia);
                    System.out.println("\nPressione ENTER para voltar ao menu...");
                    input.nextLine();
                }
            } else {
                System.out.println("Nenhum cliente foi encontrado com este e-mail ou CPF.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}