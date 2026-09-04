package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.operations.OperationResult;
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

            // O que será feito inicialmente?
            // O usuário digitará o email ou cpf do outro usuário para enviar determinada quantidade de valor.
            // Então, deve-se verificar primeiramente se determinada chave existe no banco de dados em que se aloca o email e cpf (cliente)
            // portanto:

            System.out.print("Digite o E-mail ou CPF do destinatário: ");
            String contaEscolhida = input.nextLine();

// 1. O método retorna um OperationResult, não um Cliente direto

            OperationResult resultadoBusca = transferService.buscarDestinatarioDAO(contaEscolhida, remetente);

// 2. Verifica se a busca deu certo através do status de sucesso
            if (resultadoBusca.isSucesso()) {
                // 3. Extrai o cliente que foi embutido dentro do OperationResult
                Cliente destinatario = resultadoBusca.getClienteRetornado();

                System.out.println("\n" + resultadoBusca.getMensagem());
                System.out.print("Digite o valor que deseja transferir: R$ ");
                float valor = input.nextFloat();
                input.nextLine();

                OperationResult resultadoTransferencia = transferService.realizarTransferencia(remetente, destinatario, valor);

                if (resultadoTransferencia.isSucesso()) {
                    System.out.println("\n" + resultadoTransferencia.getMensagem());
                    System.out.println("Seu novo saldo: R$ " + resultadoTransferencia.getNovoSaldoApp());
                } else {
                    System.out.println("\n[ERRO]: " + resultadoTransferencia.getMensagem());
                }
            } else {
                // Se o usuário não foi encontrado ou tentou enviar para si mesmo
                System.out.println("\n[ERRO]: " + resultadoBusca.getMensagem());
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