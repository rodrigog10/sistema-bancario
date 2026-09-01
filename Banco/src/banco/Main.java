package banco;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Inicia a aplicação
            App app = new App();
            app.iniciarSistema();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro crítico na aplicação e ela precisou ser encerrada.");
            System.out.println("Pressione ENTER para fechar o programa...");

            Scanner input = new Scanner(System.in);
            input.nextLine();
            input.close();
        }
    }
}