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
                // Nomes das colunas exatamente iguais aos do seu PostgreSQL:
                int idCofre = rs.getInt("id");
                String nome = rs.getString("nome_cofre");
                String objetivo = rs.getString("objetivo_cofre");
                float saldo = rs.getFloat("saldo_cofre");

                // Instancia o cofre e adiciona na lista

                CofreBradesco cofre = new CofreBradesco(idCofre, nome, objetivo, saldo);
                cofres.add(cofre);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar cofrinhos: " + e.getMessage());
        }

        return cofres;
    }

    public List<CofreBradesco> criarCofres() {
        List<CofreBradesco> cofres = new ArrayList<>();
        String sql = "INSERT INTO cofre_bradesco (nome_cofre, objetivo_cofre, saldo_cofre) VALUES (?, ?, ?)";
        try {
            Connection connect = DataBaseConnection.getConnection();

            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //Continuar..


        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        }
        return cofres;
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


    }


}