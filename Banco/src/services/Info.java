package services;

import domain.Bradesco;
import domain.Cliente;
import test.App;

public class Info {

    public void informacoes(Cliente cliente, Bradesco bradesco) {
        //nome, idade, saldoapp, cofrinhopc e cofrinhocasa
            try {
                System.out.println("Informações da conta: \n");
                System.out.println("Nome: " + cliente.getNome() + "\n");
                System.out.println("Idade: " + cliente.getIdade() + "\n");
                System.out.println("Saldo do app: " + bradesco.getSaldoApp() + "\n");
                System.out.println("Cofrinhos: " + "\n");
                System.out.println("CofrinhoPc: " + bradesco.getCofrinhoPc() + "\n");
                System.out.println("CofrinhoCasa: " + bradesco.getCofrinhoCasa() + "\n");
            } catch (Exception e) {
                System.out.println("Um erro inesperado aconteceu.");
            }
    }
}
