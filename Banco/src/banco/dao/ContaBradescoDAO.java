package banco.dao;

import banco.connection.DataBaseConnection;
import banco.domain.Bradesco;
import banco.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContaBradescoDAO {
    public void atualizarSaldoApp(int idConta, float novoSaldoApp) {
        String sql = "UPDATE conta_bradesco SET saldo_app = ? WHERE id = ?";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setFloat(1, novoSaldoApp);
            ps.setInt(2, idConta);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o saldo da conta: " + e.getMessage());
        }
    }


    public Cliente buscarDestinatario(String chaveEscolhida) {
        // Usando c.* para trazer todas as colunas do cliente de uma vez só
        String sql = "SELECT c.*, cb.id AS conta_id, cb.saldo_app " +
                "FROM cliente c " +
                "JOIN conta_bradesco cb ON c.id = cb.cliente_id " +
                "WHERE c.email = ? OR c.cpf = ?";

            // não podemos puxar a tabela de conta_bradesco inteira por meio de cb.* porque os id's principais possuem o mesmo nome "id".

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setString(1, chaveEscolhida);
            ps.setString(2, chaveEscolhida);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // recuperando os dados direto com o padrão do c.*
                    int idCliente = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    int senha = rs.getInt("senha");

                    // recuperando os dados da conta usando os apelidos
                    int idConta = rs.getInt("conta_id");
                    float saldoApp = rs.getFloat("saldo_app");

                    Bradesco conta = new Bradesco();
                    conta.setId(idConta);
                    conta.setSaldoApp(saldoApp);

                    return new Cliente(idCliente, nome, idade, cpf, email, senha, conta);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar o destinatário: " + e.getMessage());
        }

        return null;
    }
}
