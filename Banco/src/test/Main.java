package test;

import domain.Bradesco;
import domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        {
            clientes.add(new  Cliente("José Rodrigo", 18, "rodrigo@gmail.com", 1234));
            //0, rodrigo
            clientes.add(new Cliente("Ana Clara", 19, "anaclara@gmail.com", 123));
            //1, ana
        }
        List<Bradesco> contas = new ArrayList<>(); {
            contas.add(new Bradesco(10000, 15000, 3500, 5000)); //rodrigo
            contas.add(new Bradesco(9000, 5000, 3500, 5000));   // ana
        }


        ExecutionApp execute = new ExecutionApp();
        execute.loginApp(clientes, contas);
    }
}