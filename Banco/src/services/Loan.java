package services;
import domain.Bradesco;
import domain.Cliente;
import java.util.Scanner;

public class Loan {


    public void emprestimo(Cliente cliente, Bradesco conta) {
        float transfLimit;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite o valor para utilizar do emprestimo: ");
            float valor = input.nextFloat();
                if (valor > conta.getLimiteEmprestimo()) {
                    System.out.println("O limite do empréstimo é de R$ " +  conta.getLimiteEmprestimo());
                } else if (valor == 0) {
                    System.out.println("Valor inválido.");
                } else {
                    transfLimit = conta.getLimiteEmprestimo() - valor;

                }
        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
        }
    }
}
