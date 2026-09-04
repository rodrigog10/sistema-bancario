package banco.view;

import banco.dao.CofreDAO;
import banco.dao.ContaBradescoDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.services.OperationResult;
import banco.services.TransferService;

import java.util.List;
import java.util.Scanner;

public class TransferView {

    private final TransferService transferService = new TransferService();

    public void exibirMenuTransfer(Cliente remetente, List<Cliente> clientes) {
        Scanner input = new Scanner(System.in);
        Bradesco conta = remetente.getConta();
        float saldoAppRemetente = conta.getSaldoApp();


        try {
            System.out.println("=== ÁREA DE TRANSFERÊNCIA (PIX) ===");

            System.out.print("Digite o E-mail ou CPF do destinatário: ");
            String contaEscolhida = input.nextLine();



            Cliente destinatario = transferService.buscarDestinatario(contaEscolhida, remetente, clientes);








            Cliente destinatarioDAO = transferService.buscarDestinatarioDAO(contaEscolhida, remetente);




                System.out.println("\nDestinatário encontrado: " + destinatario.getNome());
                System.out.print("Digite o valor que deseja transferir: R$ ");
                float valor = input.nextFloat();
                input.nextLine();

                OperationResult resultado = transferService.realizarTransferencia(remetente, destinatario, valor);

                if (resultado.isSucesso()) {
                    System.out.println("\n" + resultado.getMensagem());
                    System.out.println("Seu novo saldo: R$ " + resultado.getNovoSaldoApp());
                } else {
                    System.out.println("\n[ERRO]: " + resultado.getMensagem());
                }

                System.out.println("\nPressione ENTER para voltar ao menu...");
                input.nextLine();




        } catch (Exception e) {
            System.out.println("\n[ERRO]: Entrada inválida. Por favor, tente novamente.");
            System.out.println("Pressione ENTER para voltar ao menu...");
            input.nextLine();
        }
    }
}