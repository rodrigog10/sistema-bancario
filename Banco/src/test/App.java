
package test;

import domain.Cliente;
import domain.cofreBradesco;
import services.*;

import java.util.List;
import java.util.Scanner;

public class App {
        Scanner input = new Scanner(System.in);
        Deposit deposit = new Deposit();
        DrawAndSafes draw = new DrawAndSafes();
        Info info = new Info();
        Transfer transfer = new Transfer();
        Loan loan = new Loan();

        public void iniciar(Cliente cliente, List<Cliente> clientes, List<cofreBradesco> cofres) {


                try {
                        boolean rodando = true;
                        while (rodando) {
                        System.out.println("============================");
                        System.out.println("BEM VINDO A AGÊNCIA DO BANCO");
                        System.out.println("============================");
                        System.out.println("= Menu = ");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Cofre e Saque");
                        System.out.println("3 - Consultar Saldo e Perfil");
                        System.out.println("4 - Transferência (PIX)");
                        System.out.println("5 - Solicitar Empréstimo");
                        System.out.println("0 - Sair do Sistema\n ");
                        System.out.println("============================");

                        System.out.println("Selecione a opção desejada: ");
                        int opcao = input.nextInt();
                        input.nextLine();

                                if (opcao == 1) {
                                        deposit.depositar(cliente);
                                } else if (opcao == 2) {
                                        draw.cofre(cliente);
                                } else if (opcao == 3) {
                                        info.informacoes(cliente);
                                } else if (opcao == 4) {
                                        transfer.transferir(cliente, clientes);
                                } else if (opcao == 5) {
                                        loan.emprestimo(cliente);
                                } else if (opcao == 0) {
                                        System.out.println("Saindo do banco.. Até logo!");
                                        rodando = false;

                                }
                        }

                } catch (Exception e) {
                        System.out.println("Um erro inesperado aconteceu, tente novamente.");
                        System.out.println("Erro: " + e.getMessage());
                        e.printStackTrace();
                }
        }

}
