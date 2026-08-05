package services;
import domain.Bradesco;
import domain.Cliente;
import java.util.Scanner;

public class Loan {


    public void emprestimo(Cliente cliente) {
        Bradesco conta = cliente.getConta();
        float transfLimit;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite o valor para resgatar do emprestimo (limite máximo: "+conta.getLimiteEmprestimo() + ")");
            float valor = input.nextFloat();
                if (valor > conta.getLimiteEmprestimo()) {
                    System.out.println("O limite do empréstimo é de R$" +  conta.getLimiteEmprestimo());
                } else if (valor == 0) {
                    System.out.println("Valor inválido.");
                } else {
                    transfLimit = conta.getLimiteEmprestimo() - valor;
                    conta.setSaldoApp(conta.getSaldoApp() + valor);
                    System.out.println("O empréstimo de " + valor + " foi transferido para o seu saldo bancário com sucesso.");
                }
        } catch (Exception e) {
            System.out.println("Um erro inesperado aconteceu.");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
