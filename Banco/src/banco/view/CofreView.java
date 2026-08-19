package banco.view;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.CofreService;
import banco.services.OperationResult;

import java.util.Scanner;


public class CofreView {

    private final CofreService cofreService = new CofreService();

    public void exibirMenuCofre(Cliente cliente) {

        Scanner input = new Scanner(System.in);
        Bradesco conta = cliente.getConta();
        System.out.println("=== MENU COFRE ===");
        try {
            System.out.println("Selecione a opção que deseja utilizar: ");
            System.out.println("1 - Visualizar Cofrinhos");
            System.out.println("2 - Gerenciar Cofrinhos (Editar/Excluir)");
            System.out.println("3 - Criar novo Cofrinho");
            System.out.println("0 - Voltar");
            int opcaoMenu = input.nextInt();
            input.nextLine();



            if (opcaoMenu == 1) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                } else {
                    CofreGestaoView.exibirMenuGestaoCofre(cliente);
                    System.out.println("Pressione ENTER para voltar. \n");
                    input.nextLine();
                }

            }

            if (opcaoMenu == 2) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }

                System.out.println("\n=== SEUS COFRINHOS ===");
                CofreGestaoView.exibirMenuGestaoCofre(cliente);

                System.out.println("\nSelecione o cofrinho que deseja gerenciar: ");
                int opcaoCofre = input.nextInt();
                input.nextLine();

                int indice = opcaoCofre - 1;

                // valida se o índice (cofre com base na posição) existe na lista
                if (indice >= 0 && indice < conta.getCofres().size()) {

                    // seleciona o cofre com base na posição.
                    CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                    System.out.println("\nGerenciando o cofrinho '" + cofreSelecionado.getNomeCofre() + "':");
                    System.out.println("1 - Alterar Nome");
                    System.out.println("2 - Alterar Objetivo");
                    System.out.println("3 - Excluir Cofrinho");
                    System.out.println("0 - Voltar");

                    int opcaoGerenciamento = input.nextInt();
                    input.nextLine();

                    if (opcaoGerenciamento == 1) {
                        System.out.println("Digite o novo nome do cofre: ");
                        String novoNome = input.nextLine();

                        OperationResult resultadoNome = cofreService.alteraNomeCofre(cofreSelecionado, novoNome);

                        if (resultadoNome.isSucesso()) {
                            System.out.println("\n " + resultadoNome.getMensagem());
                        } else {
                            System.out.println("\n " + resultadoNome.getMensagem());
                        }
                    }

                    if (opcaoGerenciamento == 2) {

                        System.out.println("Digite o nome do novo objetivo: ");
                        String novoObjetivo = input.nextLine();
                        OperationResult resultadoObjetivo = cofreService.alterarObjetivo(cofreSelecionado, novoObjetivo);

                        if (resultadoObjetivo.isSucesso()) {
                            System.out.println("\n " + resultadoObjetivo.getMensagem());
                        } else {
                            System.out.println("\n  " + resultadoObjetivo.getMensagem());
                        }
                    }

                    if (opcaoGerenciamento == 3) {
                        System.out.println("Tem certeza que deseja excluir o cofrinho? \n Seu saldo irá retornar para o saldo do aplicativo.");
                        System.out.println("1 - Confirmar \n 2 - Voltar");
                        int opcaoDeletar = input.nextInt();
                        input.nextLine();

                        if (opcaoDeletar == 1) {
                            OperationResult resultadoDelete = cofreService.deletarCofre(cliente, cofreSelecionado);

                            if (resultadoDelete.isSucesso()) {
                                System.out.println("\n " + resultadoDelete.getMensagem());
                                System.out.println(" Saldo atual da conta: R$ " + resultadoDelete.getNovoSaldoApp());
                            } else {
                                System.out.println("\n Erro ao excluir: " + resultadoDelete.getMensagem());
                            }
                        }
                    }

                } else {
                    System.out.println("Opção de cofrinho inválida!");
                }
            }



            // criação cofrinho

            if (opcaoMenu == 3) {

                System.out.println("Digite o nome do seu novo cofrinho: ");
                String novoNomeCofrinho = input.nextLine();

                if (novoNomeCofrinho == null || novoNomeCofrinho.trim().isEmpty()) {
                    System.out.println("\nErro: O nome do cofrinho não pode ser vazio!");
                    return;
                }

                System.out.println("Digite o objetivo do seu cofrinho: ");
                String novoObjetivoCofrinho = input.nextLine();

                if (novoObjetivoCofrinho == null || novoObjetivoCofrinho.trim().isEmpty()) {
                    System.out.println("\nErro: O objetivo do cofrinho não pode ser vazio!");
                    return;
                }

                System.out.println("Deseja inserir valor no cofrinho?");
                System.out.println("1 - Sim \n 2 - Não");

                int opcaoInserir = input.nextInt();
                input.nextLine();

                if (opcaoInserir == 1) {
                    System.out.println("Digite o valor a ser inserido: ");
                    float valorDeposito = input.nextFloat();
                    input.nextLine();

                    OperationResult resultado = cofreService.optionYes(cliente, novoNomeCofrinho, novoObjetivoCofrinho, valorDeposito);


                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem()+ " \n");
                        System.out.println("Nome: " + novoNomeCofrinho + " | Objetivo: " + novoObjetivoCofrinho + " | Saldo: R$ " + valorDeposito);
                        System.out.println("\nPressione ENTER para voltar...");
                        input.nextLine();
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("\nPressione ENTER para voltar...");
                        input.nextLine();
                    }

                } else {
                    OperationResult resultado = cofreService.optionNo(cliente, novoNomeCofrinho, novoObjetivoCofrinho);

                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem() + " \n");

                        System.out.println("Nome: " + novoNomeCofrinho);
                        System.out.println("Objetivo: " + novoObjetivoCofrinho+ "\n");

                        System.out.println("Pressione ENTER para voltar. \n");
                        input.nextLine();
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Pressione ENTER para voltar. \n");
                        input.nextLine();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu");
            System.out.println("Pressione ENTER para voltar. \n");
            input.nextLine();
        }
    }

}
