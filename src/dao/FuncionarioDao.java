package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySql;
import model.Funcionario;

public class FuncionarioDao {
    public static boolean cadastrar(Funcionario funcionario) {
        String sql;
        sql = "INSERT INTO Funcionario (nome, endereco, telefone, cpf, dt_nascimento) ";
        sql += "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEndereco());
            ps.setString(3, funcionario.getTelefone());
            ps.setString(4, funcionario.getCpf());
            ps.setObject(5, funcionario.getDt_nascimento());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }

    public static List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<Funcionario>();

        String sql = "SELECT * FROM funcionario";

        try (Connection con = ConexaoMySql.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setDt_nascimento(rs.getObject("dt_nascimento", LocalDate.class));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                lista.add(funcionario);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    public static boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET nome = ?, telefone = ?, endereco = ?, dt_nascimento = ?, cpf = ? WHERE idFuncionario = ?";
    
        try (Connection con = ConexaoMySql.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getTelefone());
            ps.setString(3, funcionario.getEndereco());
            ps.setObject(4, funcionario.getDt_nascimento());
            ps.setString(5, funcionario.getCpf());
            ps.setInt(6, funcionario.getIdFuncionario());
    
            return ps.executeUpdate() > 0;
    
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR: " + e.getMessage());
            return false;
        }
    }

    public static boolean excluir(int idFuncionario) {
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
        try (Connection con = ConexaoMySql.getConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFuncionario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("ERRO AO EXCLUIR: " + e.getMessage());
            return false;
        }
    }

}