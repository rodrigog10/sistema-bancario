package services;
import domain.Bradesco;
import domain.Cliente;
import java.util.List;
import java.util.Scanner;

public class Transfer {
    public void transferir(Cliente remetente, List<Cliente> clientes) {
        Bradesco contaRemetente = remetente.getConta();
        Cliente clienteEncontrado = null;
        boolean clientAcess = false;
        Scanner input = new Scanner(System.in);
        float valor = 0;

        try {
            System.out.println("Digite o email ou cpf do cliente: ");
            String contaDigitada = input.nextLine();
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getEmail().equals(contaDigitada) || clientes.get(i).getCpf().equals(contaDigitada)) {
                    clientAcess = true;
                    clienteEncontrado = clientes.get(i); // guardado
                    break;
                }
            }

            if (clientAcess) {
                System.out.println("Digite o valor a ser transferido para :" + clienteEncontrado.getNome());
                valor = input.nextFloat();
                if (contaRemetente.getSaldoApp() < valor) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    Bradesco contaDestinatario = clienteEncontrado.getConta();
                    float novoSaldoQuemEnvia = contaRemetente.getSaldoApp() - valor;
                    contaRemetente.setSaldoApp(novoSaldoQuemEnvia); // novo saldo definido

                    contaDestinatario.setSaldoApp(contaDestinatario.getSaldoApp() + valor); // novo saldo definido
                    System.out.println("Maravilha! o valor de " + valor + " foi enviado para " + clienteEncontrado.getNome() + " com sucesso! ");
                }
            } else {
                System.out.println("Cliente não encontrado com esse e-mail/CPF.");
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
        }

    }
}
