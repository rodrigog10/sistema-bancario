package services;

import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.Scanner;

public class DrawAndSafes {

    Scanner input = new Scanner(System.in);

    public void cofre(Cliente cliente) {
        Bradesco conta = cliente.getConta();

        System.out.println("Selecione a opção que deseja utilizar: ");
        System.out.println("1 - Visualizar Cofrinhos");
        System.out.println("2 - Criar novo Cofrinho");
        System.out.println("3 - Voltar");
        int opcao = input.nextInt();
        input.nextLine();


        if (opcao == 1) {
            if (conta.getCofres().isEmpty()) {
                System.out.println("Você não tem cofrinhos registrados.");
                System.out.println("Pressione ENTER para voltar ao menu...");
                input.nextLine();
                return;
            }

            System.out.println("\nCofrinhos: ");
            for (int i = 0; i < conta.getCofres().size(); i++) {
                cofreBradesco c = conta.getCofres().get(i);

                System.out.println((i + 1) + " - Nome: " + c.getNomeCofre() + " | Saldo: R$ " + c.getSaldoCofre());
            }
        }


        else if (opcao == 2) {
            System.out.println("Digite o nome do cofrinho: ");
            String nome = input.nextLine();

            System.out.println("Digite o objetivo do cofrinho: ");
            String objetivo = input.nextLine();

            System.out.println("Deseja inserir valor no " + nome + "?");
            System.out.println("1 - Sim \n2 - Não");
            int opcaoInserir = input.nextInt();
            input.nextLine();

            if (opcaoInserir == 1) {
                System.out.println("Digite o valor a ser inserido: ");
                float novoValorCofre = input.nextFloat();
                input.nextLine();


                if (conta.getSaldoApp() < novoValorCofre) {
                    System.out.println("Saldo insuficiente! O cofrinho não foi criado.");
                } else {

                    float novoSaldoDoApp = conta.getSaldoApp() - novoValorCofre;
                    conta.setSaldoApp(novoSaldoDoApp);

                    conta.getCofres().add(new cofreBradesco(nome, objetivo, novoValorCofre));
                    System.out.println("O cofrinho '" + nome + "' foi criado com saldo inicial de: R$ " + novoValorCofre);
                }
            } else {

                conta.getCofres().add(new cofreBradesco(nome, objetivo, 0));
                System.out.println("O cofrinho '" + nome + "' foi criado com R$ 0,00.");
            }
        }

        // ==========================================
        // OPÇÃO 3: VOLTAR
        // ==========================================
        else if (opcao == 3) {
            System.out.println("Voltando ao menu principal..");
        }
    }
}
