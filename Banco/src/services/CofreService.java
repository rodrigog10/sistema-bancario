package services;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;

import java.util.Scanner;

public class CofreService {



    Scanner input = new Scanner(System.in);

    public void cofre(Cliente cliente) {
        Bradesco conta = cliente.getConta();




        try {
            System.out.println("Selecione a opção que deseja utilizar: ");
            System.out.println("1 - Visualizar Cofrinhos");
            System.out.println("2 - Gerenciar Cofrinhos (Editar/Excluir)");
            System.out.println("3 - Criar novo Cofrinho");
            System.out.println("0 - Voltar");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                } else {
                    System.out.println("\n=== SEUS COFRINHOS ===");
                    for (int i = 0; i < conta.getCofres().size(); i++) {
                        CofreBradesco c = conta.getCofres().get(i);
                        System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + " | Objetivo: " + c.getObjetivoCofre() + " | Saldo: R$ " + c.getSaldoCofre());
                    }
                    System.out.println("\nPressione ENTER para voltar ao menu...");
                    input.nextLine();
                }
            } else if (opcao == 2) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                } else {
                    System.out.println("\n=== SEUS COFRINHOS ===");
                    for (int i = 0; i < conta.getCofres().size(); i++) {
                        CofreBradesco e = conta.getCofres().get(i);
                        System.out.println((i + 1) + " - Nome: " + e.getNomeCofre() + " | Saldo: R$ " + e.getSaldoCofre());
                    }
                }

                System.out.println("\nSelecione o cofrinho que deseja gerenciar: ");
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

                    int opcaoEdit = input.nextInt();
                    input.nextLine();

                    if (opcaoEdit == 1) {
                        System.out.println("Digite o novo nome do seu cofrinho: ");
                        String novoNomeCofre = input.nextLine();
                        cofreSelecionado.setNomeCofre(novoNomeCofre);
                        System.out.println("O nome do seu cofrinho foi alterado para: " + novoNomeCofre);

                    } else if (opcaoEdit == 2) {
                        System.out.println("Digite o novo objetivo do cofrinho: ");
                        String novoObjetivoCofre = input.nextLine();
                        cofreSelecionado.setObjetivoCofre(novoObjetivoCofre);
                        System.out.println("Objetivo alterado com sucesso!");

                    } else if (opcaoEdit == 3) {
                        float saldoResgatado = cofreSelecionado.getSaldoCofre();

                        if (saldoResgatado > 0) {
                            float novoSaldoApp = conta.getSaldoApp() + saldoResgatado;
                            conta.setSaldoApp(novoSaldoApp);
                            System.out.println("R$ " + saldoResgatado + " foram devolvidos ao seu saldo principal!");
                        }

                        conta.getCofres().remove(indice);
                        System.out.println("O cofrinho foi excluído com sucesso!");
                    }

                    System.out.println("\nPressione ENTER para voltar ao menu...");
                    input.nextLine();

                } else {
                    System.out.println("Opção inválida!");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                }

            } else if (opcao == 3) {
                System.out.println("Digite o nome do cofrinho: ");
                String nome = input.nextLine();

                System.out.println("Digite o objetivo do cofrinho: ");
                String objetivo = input.nextLine();

                System.out.println("Deseja inserir valor no cofrinho " + nome + "?");
                System.out.println("1 - Sim \n2 - Não");
                int opcaoInserir = input.nextInt();
                input.nextLine();

                if (opcaoInserir == 1) {
                    System.out.println("Digite o valor a ser inserido: ");
                    float novoValorCofre = input.nextFloat();
                    input.nextLine();

                    if (conta.getSaldoApp() < novoValorCofre) {
                        System.out.println("Saldo insuficiente! O cofrinho não foi criado.");
                        System.out.println("Pressione ENTER para voltar ao menu...");
                        input.nextLine();

                    } else {
                        float novoSaldoDoApp = conta.getSaldoApp() - novoValorCofre;
                        conta.setSaldoApp(novoSaldoDoApp);
                        CofreBradesco novoCofre = new CofreBradesco(nome, objetivo, novoValorCofre);
                        conta.getCofres().add(novoCofre);
                        System.out.println("O cofrinho '" + nome + "' foi criado com saldo inicial de: R$ " + novoValorCofre + ".");
                        System.out.println("Pressione ENTER para voltar ao menu...");
                        input.nextLine();
                    }
                } else {
                    conta.getCofres().add(new CofreBradesco(nome, objetivo, 0));
                    System.out.println("O cofrinho '" + nome + "' foi criado com R$ 0,00.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                }

            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            }

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}