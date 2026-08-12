import domain.Bradesco;
import domain.Cliente;
import domain.CofreBradesco;
import view.ExecutionApp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente("José Rodrigo", 18, "123.456.789-10", "rodrigo123@gmail.com", 1234, new Bradesco(10000, 15000, new ArrayList<>())));
            clientes.add(new Cliente("Ana Clara", 19, "123.456.789-11", "ana123@gmail.com", 1234, new Bradesco(8000, 12000, new ArrayList<>())));

            List<CofreBradesco> cofres = new ArrayList<>();
            ExecutionApp execute = new ExecutionApp();

            execute.loginApp(clientes, cofres);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro crítico na aplicação e ela precisou ser encerrada.");
        }
    }
}