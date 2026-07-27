package services;
import domain.Bradesco;
import domain.Cliente;
import java.util.Scanner;

public class Loan {


    public void emprestimo(Cliente cliente, Bradesco bradesco) {
        float transfLimit;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite o valor para utilizar do emprestimo: ");
            float valor = input.nextFloat();
                if (valor > bradesco.getlimiteEmprestimo()) {
                    System.out.println("O limite do empréstimo é de R$ " +  bradesco.getlimiteEmprestimo());
                } else if (valor <= bradesco.getlimiteEmprestimo()) {
                    System.out.println(" ");
                }
        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
        }
    }
}
