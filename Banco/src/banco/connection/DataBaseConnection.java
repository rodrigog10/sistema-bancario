package banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    // Dados de acesso do seu PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/SistemaBancario";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "leite123"; // A sua senha do banco

    // Método que a ClienteDAO vai chamar para abrir a ponte

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}