package test;

import domain.Bradesco;
import domain.Cliente;
import domain.cofreBradesco;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        {
            clientes.add(new Cliente("José Rodrigo", 18,"123.456.789-10", "rodrigo123@gmail.com", 1234, new Bradesco(10000, 15000, 3500, 4000, null)));
            //0, rodrigo
            clientes.add(new Cliente("Ana Clara", 19, "123.456.789-11","ana123@gmail.com", 1234, new Bradesco(10000, 15000, 3500, 4000, null)));
            //1, ana
        }

        List<Bradesco> Cofrinhos = new ArrayList<>();
        List<cofreBradesco> cofres = new ArrayList<>();
        ExecutionApp execute = new ExecutionApp();


        execute.loginApp(clientes, cofres);
    }
}