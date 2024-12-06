package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
