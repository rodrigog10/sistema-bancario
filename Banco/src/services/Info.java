package services;

import domain.Bradesco;
import domain.Cliente;

import java.util.Scanner;

public class Info {

    public void informacoes(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        //nome, idade, saldoapp, cofrinhopc e cofrinhocasa
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Informações da conta: \n");
                System.out.println("Nome: " + cliente.getNome() + "\n");
                System.out.println("Idade: " + cliente.getIdade() + "\n");
                System.out.println("Saldo do app: " + conta.getSaldoApp() + "\n");
                System.out.println("Cofrinhos: " + "\n");
                System.out.println("CofrinhoPc: " + conta.getCofrinhoPc() + "\n");
                System.out.println("CofrinhoCasa: " + conta.getCofrinhoCasa() + "\n");

                System.out.println("Digite 0 para voltar ao menu");
                int valor = input.nextInt();
                    if (valor == 0) {
                        return ;
                    }
            } catch (Exception e) {
                System.out.println("Um erro inesperado aconteceu.");
            }
    }
}
