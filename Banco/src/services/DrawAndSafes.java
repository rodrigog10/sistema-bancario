package services;

import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.List;
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
                        if (opcao == 1) {
                            for (int i = 0; i < conta.getCofres().size() ; i++) {
                                System.out.println(conta.getCofres().get(i).getNomeCofre());
                            }
                        }

            }
        }



