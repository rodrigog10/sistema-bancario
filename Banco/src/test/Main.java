package test;

import domain.Bradesco;
import domain.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Bradesco bradesco = new Bradesco();
        ExecutionApp execute = new ExecutionApp();
            execute.loginApp(cliente, bradesco);
    }
    }
