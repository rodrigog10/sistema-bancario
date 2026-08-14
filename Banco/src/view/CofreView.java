package view;

import domain.Bradesco;
import domain.Cliente;

import java.util.Scanner;


public class CofreView {

    private final CofreGestaoView cofreGestaoView = new CofreGestaoView();

    public void exibirMenuCofre(Cliente cliente) {


        Scanner input = new Scanner(System.in);
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
                }

                // direcionamento pro Service
            }

            if (opcao == 2) {
                if (conta.getCofres().isEmpty()) {
                    System.out.println("Você não tem cofrinhos registrados.");
                    System.out.println("Pressione ENTER para voltar ao menu...");
                    input.nextLine();
                    return;
                }

               // direcionamento pro Service

            }
            // for que exibe os cofres blz
            System.out.println("\n=== SEUS COFRINHOS ===");
            CofreViewUtils.exibirListaCofres(conta);

            System.out.println();

        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu");
        }

    }
}
