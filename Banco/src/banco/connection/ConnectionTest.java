package banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) {
        // Caminho do banco criado no pgAdmin
        String url = "jdbc:postgresql://localhost:5432/SistemaBancario";
        String usuario = "postgres";
        String senha = "leite123"; // <-- Altere para a senha do seu PostgreSQL

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ CONECTADO COM SUCESSO AO POSTGRESQL!");
            conexao.close();
        } catch (Exception e) {            System.out.println("❌ ERRO AO CONECTAR:");
            e.printStackTrace();
        }
    }
}