package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Veiculo;

public class VeiculoDao {
    public static boolean cadastrar(Veiculo veiculo) {
        String sql;
        sql = "INSERT INTO Veiculo (marca, modelo, ano, cor, placa) ";
        sql += "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setInt(3, veiculo.getAno());
            ps.setString(4, veiculo.getCor());
            ps.setString(5, veiculo.getPlaca());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }
}
