package banco.view;

import banco.domain.Cliente;
import banco.services.OperationResult;
import banco.services.TransferService;

import java.util.List;
import java.util.Scanner;

public class TransferView {

    private final TransferService transferService = new TransferService();

    public void exibirMenuTransfer(Cliente cliente, List<Cliente> clientes) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\n=== ÁREA DE TRANSFERÊNCIA (PIX) ===\n");
            System.out.print("Digite o E-mail ou CPF do destinatário: ");
            String chaveDestino = input.nextLine();


            Cliente destinatario = transferService.buscarDestinatario(chaveDestino, cliente, clientes);

            if (destinatario == null) {
                System.out.println("\n[ERRO]: Destinatário inválido.");
                System.out.println("Pressione ENTER para voltar...");
                input.nextLine();
                return;
            }



            System.out.println("\nDestinatário encontrado: " + destinatario.getNome());
            System.out.print("Digite o valor que deseja transferir: R$ ");
            float valor = input.nextFloat();
            input.nextLine();

            //dá continuidade à transferência com base na chave guardada na memória

            OperationResult resultado = transferService.realizarTransferencia(cliente, destinatario, valor);

            if (resultado.isSucesso()) {
                System.out.println("\n" + resultado.getMensagem());
                System.out.println("\nSeu novo saldo: R$ " + resultado.getNovoSaldoApp());
            } else {
                System.out.println("\n[ERRO]: " + resultado.getMensagem());
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("\n[ERRO]: Entrada inválida. Por favor, tente novamente.");
            input.nextLine();
        }
    }
}