package view;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import services.CofreService;
import services.OperationResult;

import java.util.Scanner;


public class CofreView {

    private final CofreGestaoView cofreGestaoView = new CofreGestaoView();
    private final CofreService cofreService = new CofreService();

    public void exibirMenuCofre(Cliente cliente) {



        Scanner input = new Scanner(System.in);
        Bradesco conta = cliente.getConta();

        try {
            System.out.println("Selecione a opção que deseja utilizar: ");
            System.out.println("1 - Visualizar Cofrinhos");
            System.out.println("2 - Gerenciar Cofrinhos (Editar/Excluir)");
            System.out.println("3 - Criar novo Cofrinho");
            System.out.println("0 - Voltar");
            int opcaoGerenciamento = input.nextInt();
            input.nextLine();


            // apenas mostra os cofrinhos

            if (opcaoGerenciamento == 1) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }
                cofreGestaoView.exibirMenuGestaoCofre(cliente);
                // direcionamento pro Service (n tem)

            }

            if (opcaoGerenciamento == 2) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }
                // inicio do gerenciamento

                System.out.println("\n=== SEUS COFRINHOS ===");
                cofreGestaoView.exibirMenuGestaoCofre(cliente);

                System.out.println("Selecione o cofrinho que deseja gerenciar: ");
                int selecao = input.nextInt();
                int indiceSelecao = selecao - 1;

               // direcionamento pro Service
                    CofreBradesco cofreSelecionado = conta.getCofres().get(indiceSelecao);

                    OperationResult resultadoSelecao = cofreService.gerenciamentoCofre(cliente, cofreSelecionado, indiceSelecao);

            }


            // for que exibe os cofres blz
            CofreViewUtils.exibirListaCofres(conta);

            System.out.println("\nSelecione o cofrinho que deseja gerenciar: ");
            int opcaoCofre =  input.nextInt();
            input.nextLine();

            int indice = opcaoCofre - 1;

            if (indice >= 0 && indice < conta.getCofres().size()) {

                CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                System.out.println("\nGerenciando o cofrinho '" + cofreSelecionado.getNomeCofre() + "':");
                System.out.println("1 - Alterar Nome");
                System.out.println("2 - Alterar Objetivo");
                System.out.println("3 - Excluir Cofrinho");
                System.out.println("0 - Voltar");

            }
            int opcaoEdit = input.nextInt();
            input.nextLine();

                // devo começar daqui né por mim mesmo

                if (opcaoEdit == 1 ) {
                    System.out.println("Digite o novo nome do cofre: ");
                    String novoNome = input.nextLine();
                        OperationResult resultado = cofreService.nomeCofre(cliente, novoNome);

                }


        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu");
        }

    }
}
