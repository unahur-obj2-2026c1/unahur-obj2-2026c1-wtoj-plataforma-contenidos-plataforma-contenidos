package ar.edu.unahur.obj2.wtoj;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    private static Plataforma instance = new Plataforma();

    private Plataforma() {
    };

    private List<Usuario> usuarios = new ArrayList<>();

    public static Plataforma getIntance() {
        return instance;
    }

    public Double facturacionMensual() {
        return usuarios.stream().mapToDouble(u -> u.costoMensual()).sum();
    }

    public void limpiarContenidos() {
        usuarios.stream().forEach(u -> u.limpiarContenidos());
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}