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

        System.out.println("=== MENU COFRE === \n");
        try {
            System.out.println("\nSelecione a opção que deseja utilizar: \n ");
            System.out.println("1 - Visualizar Cofrinhos");
            System.out.println("2 - Gerenciar Cofrinhos (Editar/Excluir)");
            System.out.println("3 - Criar novo Cofrinho");
            System.out.println("0 - Voltar");
            System.out.print("> ");

            int opcaoMenu = input.nextInt();
            input.nextLine();

            if (opcaoMenu == 1) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("\nVocê não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                } else {
                    System.out.println();
                    CofreGestaoView.exibirMenuGestaoCofre(cliente);
                    System.out.println("\nPressione ENTER para voltar...");
                    input.nextLine();
                }
            }

            if (opcaoMenu == 2) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("\nVocê não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }

                System.out.println("\n === SEUS COFRINHOS === \n");
                CofreGestaoView.exibirMenuGestaoCofre(cliente);

                System.out.println("Selecione o cofrinho que deseja gerenciar:");
                System.out.print("> ");
                int opcaoCofre = input.nextInt();
                input.nextLine();

                int indice = opcaoCofre - 1;

                if (indice >= 0 && indice < conta.getCofres().size()) {
                    CofreBradesco cofreSelecionado = conta.getCofres().get(indice);

                    System.out.println("\nGerenciando o cofrinho '" + cofreSelecionado.getNomeCofre() + "':");
                    System.out.println("1 - Alterar Nome");
                    System.out.println("2 - Alterar Objetivo");
                    System.out.println("3 - Excluir Cofrinho");
                    System.out.println("0 - Voltar");
                    System.out.print("> ");

                    int opcaoGerenciamento = input.nextInt();
                    input.nextLine();

                    if (opcaoGerenciamento == 1) {
                        System.out.print("\nDigite o novo nome do cofre: ");
                        String novoNome = input.nextLine();

                        OperationResult resultadoNome = cofreService.alteraNomeCofre(cofreSelecionado, novoNome);
                        System.out.println(resultadoNome.getMensagem());
                    }

                    if (opcaoGerenciamento == 2) {
                        System.out.print("\nDigite o nome do novo objetivo: ");
                        String novoObjetivo = input.nextLine();
                        OperationResult resultadoObjetivo = cofreService.alterarObjetivo(cofreSelecionado, novoObjetivo);

                        System.out.println(resultadoObjetivo.getMensagem());
                    }

                    if (opcaoGerenciamento == 3) {
                        System.out.println("\nTem certeza que deseja excluir o cofrinho?");
                        System.out.println("Seu saldo irá retornar para o saldo do aplicativo.");
                        System.out.println("1 - Confirmar");
                        System.out.println("2 - Voltar");
                        System.out.print("> ");
                        int opcaoDeletar = input.nextInt();
                        input.nextLine();

                        if (opcaoDeletar == 1) {
                            OperationResult resultadoDelete = cofreService.deletarCofre(cliente, cofreSelecionado);

                            if (resultadoDelete.isSucesso()) {
                                System.out.println("\n" + resultadoDelete.getMensagem());
                                System.out.println("Saldo atual da conta: R$ " + resultadoDelete.getNovoSaldoApp());
                            } else {
                                System.out.println("\nErro ao excluir: " + resultadoDelete.getMensagem());
                            }
                        }
                    }

                } else {
                    System.out.println("\nOpção de cofrinho inválida!");
                }
            }

            if (opcaoMenu == 3) {
                System.out.print("\nDigite o nome do seu novo cofrinho: \n");
                String novoNomeCofrinho = input.nextLine();

                if (novoNomeCofrinho == null || novoNomeCofrinho.trim().isEmpty()) {
                    System.out.println("Erro: O nome do cofrinho não pode ser vazio!");
                    return;
                }

                System.out.print("Digite o objetivo do seu cofrinho: \n");
                String novoObjetivoCofrinho = input.nextLine();

                if (novoObjetivoCofrinho == null || novoObjetivoCofrinho.trim().isEmpty()) {
                    System.out.println("Erro: O objetivo do cofrinho não pode ser vazio!");
                    return;
                }

                System.out.println("\nDeseja inserir valor no cofrinho? \n");
                System.out.println("\n1 - Sim");
                System.out.println("2 - Não");
                System.out.print("> ");

                int opcaoInserir = input.nextInt();
                input.nextLine();

                if (opcaoInserir == 1) {
                    System.out.print("\nDigite o valor a ser inserido: R$ ");
                    float valorDeposito = input.nextFloat();
                    input.nextLine();

                    OperationResult resultado = cofreService.optionYes(cliente, novoNomeCofrinho, novoObjetivoCofrinho, valorDeposito);

                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Nome: " + novoNomeCofrinho + " | Objetivo: " + novoObjetivoCofrinho + " | Saldo: R$ " + valorDeposito);
                        System.out.println("\nPressione ENTER para voltar...");
                        input.nextLine();
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Pressione ENTER para voltar...");
                        input.nextLine();
                    }

                } else {
                    OperationResult resultado = cofreService.optionNo(cliente, novoNomeCofrinho, novoObjetivoCofrinho);

                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Nome: " + novoNomeCofrinho);
                        System.out.println("Objetivo: " + novoObjetivoCofrinho);
                        System.out.println("\nPressione ENTER para voltar...");
                        input.nextLine();
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Pressione ENTER para voltar...");
                        input.nextLine();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("\nUm erro inesperado aconteceu.");
            System.out.println("Pressione ENTER para voltar...");
            input.nextLine();
        }
    }

}