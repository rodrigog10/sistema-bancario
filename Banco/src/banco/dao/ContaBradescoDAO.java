package banco.dao;

import banco.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContaBradescoDAO {
    public void atualizarSaldoApp(int idContaDEO, float novoSaldoApp) {
        String sql = "UPDATE conta_bradesco SET saldo_app = ? WHERE id = ?";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setFloat(1, novoSaldoApp);
            ps.setInt(2, idContaDEO);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o saldo da conta: " + e.getMessage());
        }
    }
}
