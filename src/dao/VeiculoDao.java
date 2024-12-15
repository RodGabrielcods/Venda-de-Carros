package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySql;
import model.Funcionario;
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

    public static List<Veiculo> listar() {
        List<Veiculo> lista = new ArrayList<Veiculo>();

        String sql = "SELECT * FROM veiculo";

        try (Connection con = ConexaoMySql.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setAno(rs.getInt("ano"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                lista.add(veiculo);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    public static boolean atualizarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE Veiculo SET marca = ?, modelo = ?, ano = ?, cor = ?, placa = ? WHERE idFuncionario = ?";
    
        try (Connection con = ConexaoMySql.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, veiculo.getAno());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setObject(4, veiculo.getPlaca());
            ps.setString(5, veiculo.getCor());
            ps.setInt(6, veiculo.getIdVeiculo());
    
            return ps.executeUpdate() > 0;
    
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR: " + e.getMessage());
            return false;
        }
    }

}
