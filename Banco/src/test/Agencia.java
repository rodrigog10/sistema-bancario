package test;

import domain.Cliente;

public class Agencia {
        Cliente cliente = new Cliente();
        public void iniciar(Cliente cliente) {
                try {
                        System.out.println("============================");
                        System.out.println("=====BEM VINDO AO BANCO=====");
                        System.out.println("============================");
                        System.out.println("= Menu = ");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Sacar");
                        System.out.println("3 - Consultar Saldo e Perfil");
                        System.out.println("4 - Transferência (PIX)");
                        System.out.println("5 - Solicitar Empréstimo");
                        System.out.println("6 - Sair do Sistema");
                } catch (Exception e) {
                        System.out.println("Um erro inesperado aconteceu, tente novamente.");
                }
        }

}
