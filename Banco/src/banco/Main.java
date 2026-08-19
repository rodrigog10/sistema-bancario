package banco;

import banco.domain.Bradesco;
import banco.domain.Cliente;
import banco.domain.CofreBradesco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        try {
            // dados fictícios para execução do sistema.
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente("José Rodrigo", 18, "123.456.789-10", "rodrigo123@gmail.com", 1234, new Bradesco(10000, new ArrayList<>())));
            clientes.add(new Cliente("Ana Clara", 19, "123.456.789-11", "ana123@gmail.com", 1234, new Bradesco(8000, new ArrayList<>())));

            List<CofreBradesco> cofres = new ArrayList<>();

            // inicialização do sistema
            banco.App app = new banco.App();
            app.iniciarSistema(clientes, cofres);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro crítico na aplicação e ela precisou ser encerrada.");

        }
    }
}