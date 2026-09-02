package banco.dao;

import banco.connection.DataBaseConnection;
import banco.domain.CofreBradesco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CofreDAO {
    public List<CofreBradesco> buscarCofres(int id) {
        List<CofreBradesco> cofres = new ArrayList<>();
        String sql = "SELECT * FROM cofre_bradesco WHERE conta_id = ?";

        try (Connection connect = DataBaseConnection.getConnection(); PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCofre = rs.getInt("id");
                int idContaBanco = rs.getInt("conta_id");
                String nome = rs.getString("nome_cofre");
                String objetivo = rs.getString("objetivo_cofre");
                float saldo = rs.getFloat("saldo_cofre");


                CofreBradesco cofre = new CofreBradesco(idCofre, idContaBanco, nome, objetivo, saldo);
                cofres.add(cofre);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar cofrinhos: " + e.getMessage());
        }

        return cofres;
    }


    public boolean criarCofreComSaldo(CofreBradesco novoCofreComSaldo) {
        String sql = "INSERT INTO cofre_bradesco (conta_id, nome_cofre, objetivo_cofre, saldo_cofre) VALUES (?, ?, ?, ?)";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setInt(1, novoCofreComSaldo.getContaId());
            ps.setString(2, novoCofreComSaldo.getNomeCofre());
            ps.setString(3, novoCofreComSaldo.getObjetivoCofre());
            ps.setFloat(4, novoCofreComSaldo.getSaldoCofre());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao criar cofre: " + e.getMessage());
            return false; // Falha: aconteceu algum erro no banco
        }
    }


    public boolean criarCofreSemSaldo(CofreBradesco novoCofreSemSaldo) {
        String sql = "INSERT INTO cofre_bradesco (conta_id, nome_cofre, objetivo_cofre, saldo_cofre) values (?,?,?,?)";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setInt(1, novoCofreSemSaldo.getContaId());
            ps.setString(2, novoCofreSemSaldo.getNomeCofre());
            ps.setString(3, novoCofreSemSaldo.getObjetivoCofre());
            ps.setFloat(4, novoCofreSemSaldo.getSaldoCofre());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao criar cofre: " + e.getMessage());
        }
        return false;
    }

    public void depositarCofre(int cofreId, float valorDeposito) {
        String sql = "UPDATE cofre_bradesco SET saldo_cofre = ? WHERE id = ?";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setFloat(1, valorDeposito);
            ps.setInt(2, cofreId);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao depositar no cofre: " + e.getMessage());
        }

    }


    public void atualizarNomeCofre(String novoNome, int idCofre) {

        String sql = "UPDATE cofre_bradesco SET nome_cofre = ? WHERE id = ?";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setString(1, novoNome);
            ps.setInt(2, idCofre);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o nome do cofre: " + e.getMessage());
        }
    }


    public void atualizarObjetivoCofre(String novoObjetivo, int idCofre) {
        String sql = "UPDATE cofre_bradesco SET objetivo_cofre = ? WHERE id = ?";

        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, novoObjetivo);
            ps.setInt(2, idCofre);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o nome do cofre: " + e.getMessage());
        }
    }


    public void deletarCofre(int cofreId) {

        String sql = "DELETE FROM cofre_bradesco WHERE id = ?";
        try (Connection connect = DataBaseConnection.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setInt(1, cofreId);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao deletar o cofre: " + e.getMessage());
        }
    }


}