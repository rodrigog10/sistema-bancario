package banco.dao;

import banco.connection.DataBaseConnection;
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


    public int buscarDestinatario(String chave) {
        String sql = "SELECT c.id FROM conta_bradesco c " +
                "JOIN clientes cl ON c.cliente_id = cl.id " +
                "WHERE cl.email = ? OR cl.cpf = ?";

        try (Connection connect = DataBaseConnection.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setString(1, chave);
            ps.setString(2, chave);

            ResultSet rs  = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar os contas: " + e.getMessage());
        }


    }
}
