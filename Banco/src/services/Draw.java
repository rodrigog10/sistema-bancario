package services;
import domain.Bradesco;
import domain.Cliente;
import test.App;
import java.util.Scanner;

public class Draw {
        public void sacar(Cliente cliente, Bradesco bradesco) {
            Scanner input = new Scanner(System.in);
            try {
                float valor;
                float draw;
                System.out.println("Selecione a opção de saque: ");
                System.out.println("1 - Cofrinho Pc");
                System.out.println("2 - Cofrinho Casa");
                int option = input.nextInt();
                    if (option == 1) {
                        System.out.println("Digite o valor que deseja sacar: ");
                        valor = input.nextFloat();
                        input.nextLine();
                            if (bradesco.getCofrinhoPc() < valor) {
                                System.out.println("Valor insuficiente.");
                                return;
                            } else {
                                draw = bradesco.getCofrinhoPc() - valor;
                                bradesco.setCofrinhoPc(draw);
                                bradesco.setSaldoApp(bradesco.getSaldoApp() + valor);
                                input.nextLine();
                                System.out.println("Saque realizado com sucesso! O valor de " + valor + " foi adicionado ao seu saldo principal.");
                            }
                    }
                    else if (option == 2) {
                        System.out.println("Digite o valor que deseja sacar: ");
                        valor =  input.nextFloat();
                        input.nextLine();
                            if (bradesco.getCofrinhoCasa() < valor) {
                                System.out.println("Valor insuficiente.");
                                return;
                            } else {
                                draw = bradesco.getCofrinhoCasa() - valor;
                                bradesco.setCofrinhoCasa(draw);
                                bradesco.setSaldoApp(bradesco.getSaldoApp() + valor);
                                input.nextLine();
                                System.out.println("Saque realizado com sucesso! O valor de " + valor + " foi adicionado ao seu saldo principal.");
                            }
                    }
            } catch (Exception e) {
                System.out.println("Um erro inesperado aconteceu.");
            }
        }
}

