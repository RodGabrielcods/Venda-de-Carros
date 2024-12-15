package model;

public class SessaoUsuario {
    private static String nomeUsuario;

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nome) {
        nomeUsuario = nome;
    }
}
