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
        System.out.println("1 - Visualizar Cofrinhos: ");
        System.out.println("2 - Criar novo Cofrinho: ");
        System.out.println("3 - Voltar: ");
        int opcao = input.nextInt();
        input.nextLine();


        if (opcao == 1) {
            for (int i = 0; i < conta.getCofres().size(); i++) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você ainda não tem nenhum cofrinho.");
                    input.nextLine();

                } else if (!conta.getCofres().isEmpty()) {
                    cofreBradesco c = conta.getCofres().get(i);
                    // Posição exposta ao cliente por meio da contagem iniciada por 1.
                    System.out.println((i + 1) + " - Nome: " + c.getNomeCofre());
                    //AJEITAR ESSA BAGAÇA AQUI
                }
            }
        }

        else if (opcao == 2) {
            System.out.println("Digite o nome do cofrinho: ");
            String nome = input.nextLine();

            System.out.println("Digite o objetivo do cofrinho: ");
            String objetivo = input.nextLine();

            System.out.println("Deseja inserir valor no " + nome + "?");
            System.out.println("1 - Sim \n 2 - Não");
            int opcaoInserir = input.nextInt();

            if (opcaoInserir == 1) {
                System.out.println("Digite o valor a ser inserido: ");
                float novoValorCofre = input.nextFloat();

                if (conta.getSaldoApp() < novoValorCofre) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    conta.getCofres().add(new cofreBradesco(nome, objetivo, novoValorCofre));
                    System.out.println("O cofrinho foi criado com saldo inicial de: R$" + novoValorCofre + ".");
                }
            } else {
                conta.getCofres().add(new cofreBradesco(nome, objetivo, 0));

            }
        }
    }
}