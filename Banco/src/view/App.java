package view;

import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import services.*;

import java.util.List;
import java.util.Scanner;

public class App {
        Scanner input = new Scanner(System.in);
        DepositView depositView = new DepositView();
        CofreService draw = new CofreService();
        AccountInfoService info = new AccountInfoService();
        TransferService transfer = new TransferService();
        LoanService loan = new LoanService();
        WithdrawView withdrawView = new WithdrawView();

        public void iniciar(Cliente cliente, List<Cliente> clientes, List<CofreBradesco> cofres) {
                try {
                        Bradesco conta = cliente.getConta();
                        boolean rodando = true;
                        while (rodando) {
                                System.out.println("============================");
                                System.out.println("BEM VINDO A AGÊNCIA DO BANCO");
                                System.out.println("============================");

                                System.out.println("   Menu  \n ");
                                System.out.println("Seu saldo: R$" + conta.getSaldoApp() +"  \n");

                                System.out.println("1 - Depositar");
                                System.out.println("2 - Sacar");
                                System.out.println("3 - Cofre");
                                System.out.println("4 - Consultar Saldo e Perfil");
                                System.out.println("5 - Transferência (PIX)");
                                System.out.println("6 - Solicitar Empréstimo");
                                System.out.println("0 - Sair do Sistema\n ");
                                System.out.println("============================");

                                System.out.println("Selecione a opção desejada: \n");
                                int opcao = input.nextInt();
                                input.nextLine();

                                if (opcao == 1) {
                                        depositView.exibirMenuDeposito(cliente);
                                } else if (opcao == 2) {
                                        withdrawView.exibirMenuSaque(cliente);
                                } else if (opcao == 3) {
                                        draw.cofre(cliente);
                                } else if (opcao == 4) {
                                        info.informacoes(cliente);
                                } else if (opcao == 5) {
                                        transfer.transferir(cliente, clientes);
                                } else if (opcao == 6) {
                                        loan.emprestimo(cliente);
                                } else if (opcao == 0) {
                                        System.out.println("Saindo do banco.. Até logo!");
                                        rodando = false;
                                } else {
                                        System.out.println("Opção inválida, tente novamente.\n");
                                }
                        }

                } catch (Exception e) {
                        System.out.println("Um erro inesperado aconteceu, tente novamente.");
                        input.nextLine();
                }
        }
}