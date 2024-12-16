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

    public static boolean verificarUsuario(String nome_usuario, String senha) {
        String sql = "SELECT * FROM Usuario WHERE nome_usuario = ? AND senha = ?";

        try (Connection con = ConexaoMySql.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome_usuario);
            ps.setString(2, senha);

            return ps.executeQuery().next();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
    }

    public static boolean verificarAdministrador() {
        String sql = "SELECT * FROM Usuario WHERE nome_usuario = 'admin' AND senha = 'admin'";

        try (Connection con = ConexaoMySql.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            return ps.executeQuery().next();

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
    }

    public static boolean excluir(String cpf) {
        String sql = "DELETE FROM Usuario WHERE nome_usuario = ?";

        try (Connection conn = ConexaoMySql.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            return false;
        }
    }

}
