package services;
import domain.Bradesco;
import domain.Cliente;

import java.util.Scanner;

public class Draw {
        public void sacar(Cliente cliente) {
            Bradesco conta = cliente.getConta();

            Scanner input = new Scanner(System.in);
            float valor;
            float draw;
            boolean rodando = true;
            try {
                    while (rodando) {
                        System.out.println("Selecione a opção de saque: ");
                        System.out.println("1 - Cofrinho Pc - R$" + conta.getCofrinhoPc());
                        System.out.println("2 - Cofrinho Casa - R$" + conta.getCofrinhoCasa());
                        System.out.println("0 - Sair para o menu");
                        int option = input.nextInt();
                        input.nextLine();
                        if (option == 1) {
                            System.out.println("Digite o valor que deseja sacar: ");
                            valor = input.nextFloat();
                            input.nextLine();
                            if (conta.getCofrinhoPc() < valor) {
                                System.out.println("Valor insuficiente.");

                            } else {
                                draw = conta.getCofrinhoPc() - valor;
                                conta.setCofrinhoPc(draw);
                                conta.setSaldoApp(conta.getSaldoApp() + valor);
                                System.out.println("Saque realizado com sucesso! O valor de " + valor + " foi adicionado ao seu saldo principal.");

                            }
                        }
                        else if (option == 2) {
                            System.out.println("Digite o valor que deseja sacar: ");
                            valor =  input.nextFloat();
                            input.nextLine();
                            if (conta.getCofrinhoCasa() < valor) {
                                System.out.println("Valor insuficiente.");

                            } else {
                                draw = conta.getCofrinhoCasa() - valor;
                                conta.setCofrinhoCasa(draw);
                                conta.setSaldoApp(conta.getSaldoApp() + valor);
                                System.out.println("Saque realizado com sucesso! O valor de " + valor + " foi adicionado ao seu saldo principal.");

                            }
                        }
                        else if (option == 0) {
                            System.out.println("Voltando ao menu.. ");
                            rodando = false;
                        }
                    }
            } catch (Exception e) {
                System.out.println("Um erro inesperado aconteceu.");
            }
        }
}

