package banco.view.cofreView;

import banco.dao.CofreDAO;
import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;
import banco.services.cofreServices.CofreService;
import banco.services.OperationResult;
import banco.view.CofreGestaoView;

import java.util.List;
import java.util.Scanner;

public class CofreView {
    private final DepositCofreView depositView = new DepositCofreView();
    private final WithdrawCofreView withdrawView = new WithdrawCofreView();
    private final CofreService cofreService = new CofreService();
    private final CofreDAO cofreDAO = new CofreDAO();

    public void exibirMenuCofre(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        Bradesco conta = cliente.getConta();
        int contaId = conta.getId();
        float saldoApp = conta.getSaldoApp();

        System.out.println("    ~ Meus cofrinhos      \n");
        try {
            System.out.println("\nSelecione a opção que deseja utilizar: \n ");

            System.out.println("1 - Criar novo Cofrinho");
            System.out.println("2 - Gerenciar Cofrinhos");
            System.out.println("3 - Visualizar Cofrinhos");
            System.out.println("0 - Voltar");

            System.out.print("> ");

            int opcaoMenu = input.nextInt();
            input.nextLine();
            List<CofreBradesco> cofres = cofreDAO.buscarCofres(conta.getId());

            if (opcaoMenu == 1) {
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

                    OperationResult resultado = cofreService.optionComSaldo(conta, contaId, saldoApp, novoNomeCofrinho, novoObjetivoCofrinho, valorDeposito);

                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem()+"n");
                        System.out.println("Nome: " + novoNomeCofrinho + " | Objetivo: " + novoObjetivoCofrinho + " | Saldo: R$ " + valorDeposito);
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                    }
                    System.out.println("\nPressione ENTER para voltar...");
                    input.nextLine();

                } else {
                    OperationResult resultado = cofreService.optionSemSaldo(conta, contaId, novoNomeCofrinho, novoObjetivoCofrinho);

                    if (resultado.isSucesso()) {
                        System.out.println("\n" + resultado.getMensagem());
                        System.out.println("Nome: " + novoNomeCofrinho);
                        System.out.println("Objetivo: " + novoObjetivoCofrinho);
                    } else {
                        System.out.println("\n" + resultado.getMensagem());
                    }
                    System.out.println("\nPressione ENTER para voltar...");
                    input.nextLine();
                }
            }

            if (opcaoMenu == 2) {
                if (cofres.isEmpty()) {
                    System.out.println("\nVocê não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }

                CofreGestaoView.exibirMenuGestaoCofre(cofres);
                System.out.println("Selecione o cofrinho que deseja gerenciar:");
                System.out.print("> ");
                int opcaoCofre = input.nextInt();
                input.nextLine();

                int indice = opcaoCofre - 1;

                if (indice >= 0 && indice < cofres.size()) {
                    CofreBradesco cofreSelecionado = cofres.get(indice);

                    System.out.println("\nGerenciando o cofrinho '" + cofreSelecionado.getNomeCofre() + "':");

                    System.out.println("1 - Depositar");
                    System.out.println("2 - Sacar");
                    System.out.println("3 - Editar Cofrinho");
                    System.out.println("0 - Voltar ");
                    System.out.print("> ");



                    int opcaoGerenciamento = input.nextInt();
                    input.nextLine();

                    if (opcaoGerenciamento == 1) {
                        depositView.exibirMenuDeposito(cliente, cofreSelecionado, opcaoCofre);
                    }
                    if (opcaoGerenciamento == 2) {
                        withdrawView.exibirMenuSaque(cliente, cofreSelecionado, opcaoCofre);
                    }
                    if (opcaoGerenciamento == 3) {
                        System.out.println("1 - Alterar Nome");
                        System.out.println("2 - Alterar Objetivo");
                        System.out.println("3 - Excluir Cofrinho");
                        System.out.println("0 - Voltar");
                        System.out.print("> ");
                            int opcaoEdit = input.nextInt();
                            input.nextLine();

                                switch (opcaoEdit) {
                                    case 1:
                                        System.out.print("\nDigite o novo nome do cofre: ");
                                        String novoNome = input.nextLine();

                                        OperationResult resultadoNome = cofreService.alteraNomeCofre(novoNome, cofreSelecionado);
                                        System.out.println(resultadoNome.getMensagem());

                                        break;
                                    case 2:
                                        System.out.print("\nDigite o nome do novo objetivo: ");
                                        String novoObjetivo = input.nextLine();

                                        OperationResult resultadoObjetivo = cofreService.alterarObjetivo(cofreSelecionado, novoObjetivo);
                                        System.out.println(resultadoObjetivo.getMensagem());
                                        break;
                                    case 3:
                                        System.out.println("\nTem certeza que deseja excluir o cofrinho?");
                                        System.out.println("Seu saldo irá retornar para o saldo do aplicativo.");
                                        System.out.println("1 - Confirmar");
                                        System.out.println("2 - Voltar");
                                        System.out.print("> ");
                                        int opcaoDeletar = input.nextInt();
                                        input.nextLine();

                                        if (opcaoDeletar == 1) {
                                            OperationResult resultadoDelete = cofreService.deletarCofre(cofreSelecionado, cliente);

                                            if (resultadoDelete.isSucesso()) {
                                                System.out.println("\n" + resultadoDelete.getMensagem());
                                            } else {
                                                System.out.println("\nErro ao excluir: " + resultadoDelete.getMensagem());
                                            }
                                            System.out.println("Pressione ENTER para voltar...");
                                            input.nextLine();
                                            break;
                                        }
                                }
                    }
                } else {
                    System.out.println("\nOpção de cofrinho inválida!");
                }
            }

            if (opcaoMenu == 3) {
                if (cofres.isEmpty()) {
                    System.out.println("\nVocê não tem cofrinhos registrados.");
                } else {
                    CofreGestaoView.exibirMenuGestaoCofre(cofres);
                }
                System.out.println("\nPressione ENTER para voltar ao menu...");
                input.nextLine();
            }

        } catch (Exception e) {
            System.out.println("\nUm erro inesperado aconteceu.");
            System.out.println("Pressione ENTER para voltar...");
            input.nextLine();
        }
    }
}