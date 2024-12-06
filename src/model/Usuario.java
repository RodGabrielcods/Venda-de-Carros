package model;

public class Usuario {
    private int idUsuario;
    private String senha, nome_usuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String senha, String nome_usuario) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.nome_usuario = nome_usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
}
