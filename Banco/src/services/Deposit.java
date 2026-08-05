package services;

import domain.Bradesco;
import domain.Cliente;
import test.App;

import java.util.Scanner;

public class Deposit {
    Scanner input = new Scanner(System.in);

    public void depositar(Cliente cliente) {
        Bradesco conta = cliente.getConta();

        try {
            float valor;
            System.out.println("Saldo disponível no App: R$ " + conta.getSaldoApp());
            System.out.println("Cofrinhos: ");
            System.out.println("---- Selecione onde você deseja depositar: ");
            int opcao = input.nextInt();
            input.nextLine();


        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu, tente novamente.");
            input.nextLine();
        }
    }
}