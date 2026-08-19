package view;

import domain.Cliente;
import services.OperationResult;
import services.TransferService;

import java.util.List;
import java.util.Scanner;

public class TransferView {

    private final TransferService transferService = new TransferService();

    public void exibirMenuTransfer(Cliente cliente, List<Cliente> clientes) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\n=== ÁREA DE TRANSFERÊNCIA (PIX) ===");
            System.out.println("Saldo disponível: R$ " + cliente.getConta().getSaldoApp());

            System.out.print("Digite o E-mail ou CPF do destinatário: ");
            String chaveDestino = input.nextLine();

            System.out.print("Digite o valor a ser transferido: R$ ");
            float valor = input.nextFloat();
            input.nextLine(); // Limpa o buffer do scanner

            // Envia para o Service processar tudo em uma única chamada
            OperationResult resultado = transferService.realizarTransferencia(cliente, chaveDestino, valor, clientes);

            if (resultado.isSucesso()) {
                System.out.println("\n" + resultado.getMensagem());
                System.out.println("Seu novo saldo: R$ " + resultado.getNovoSaldoApp());
            } else {
                System.out.println("\n[ERRO]: " + resultado.getMensagem());
            }

            System.out.println("\nPressione ENTER para voltar ao menu...");
            input.nextLine();

        } catch (Exception e) {
            System.out.println("\n[ERRO]: Entrada inválida. Por favor, digite os dados corretamente.");
            input.nextLine(); // Trata o buffer no catch para evitar loops
        }
    }
}