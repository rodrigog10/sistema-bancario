package banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.connection.DataBaseConnection; // Importa a classe de conexao correta
import banco.domain.Cliente;                // Importa a classe Cliente do seu projeto

public class ClienteDAO {

    public Cliente autenticar(String email, int senha) {
        // 1° a ‘String’ sql guarda o comando que será passado.
        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";


        //2° inicializando esse 1° try, é executada a verificação de permissão para o acesso ao banco de dados.
        try (Connection conexao = DataBaseConnection.getConnection();
             //3° A variável command carrega o comando sql escrito ali em cima, ainda com os 2 campos vazios (email e senha (?))
             PreparedStatement command = conexao.prepareStatement(sql)) {

            // 3. Aqui ele preenche a variável email(?) com o input digitado e a variável senha(?) com o input digitado também.
            command.setString(1, email);
            command.setInt(2, senha);

            // 4. Aqui ele guarda dentro da variável rs o executeQuery() que se baseia nas informações contidas em command para verificar se há, naquele banco de dados, as informações digitadas.
            try (ResultSet rs = command.executeQuery()) {

                // 5. Se o banco encontrou o cliente, lê os dados.
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    String cpf = rs.getString("cpf");
                    String emailBanco = rs.getString("email");
                    int senhaBanco = rs.getInt("senha");

                    // Instancia e devolve o cliente montado
                    return new Cliente(nome, idade, cpf, emailBanco, senhaBanco, null);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao consultar o cliente no banco: " + e.getMessage());
        }

        return null;
    }
}