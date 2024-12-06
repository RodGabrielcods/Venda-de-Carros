package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Usuario;

public class UsuarioDao {
    public static boolean cadastrar(Usuario usuario) {
        String sql;
        sql = "INSERT INTO Usuario (nome_usuario, senha) ";
        sql += "VALUES (?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome_usuario());
            ps.setString(2, usuario.getSenha());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }
}
