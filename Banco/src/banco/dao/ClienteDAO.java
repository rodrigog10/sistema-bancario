package banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.connection.DataBaseConnection;
import banco.domain.Bradesco;
import banco.domain.Cliente;


public class                ClienteDAO {

    public Cliente autenticar(String email, int senha) {

        // comando com o LEFT JOIN para trazer o saldo_app junto
        String sql = "SELECT c.*, cb.id AS conta_id, cb.saldo_app \n" +
                "FROM cliente c \n" +
                "LEFT JOIN conta_bradesco cb ON c.id = cb.cliente_id \n" +
                "WHERE c.email = ? AND c.senha = ?";

        try (Connection conexao = DataBaseConnection.getConnection();
             PreparedStatement command = conexao.prepareStatement(sql)) {

            command.setString(1, email);
            command.setInt(2, senha);

            try (ResultSet rs = command.executeQuery()) {
                if (rs.next()) {
                    int idCliente = rs.getInt("id");             // ID da tabela 'cliente'
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    String cpf = rs.getString("cpf");
                    String emailBanco = rs.getString("email");
                    int senhaBanco = rs.getInt("senha");

                    float saldo = rs.getFloat("saldo_app");
                    int idConta = rs.getInt("conta_id");         // ID da tabela 'conta_bradesco'

                    Bradesco conta = new Bradesco();
                    conta.setId(idConta);
                    conta.setSaldoApp(saldo);


                    return new Cliente(idCliente, nome, idade, cpf, emailBanco, senhaBanco, conta);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao consultar o cliente no banco: " + e.getMessage());
        }

        return null;
    }


}