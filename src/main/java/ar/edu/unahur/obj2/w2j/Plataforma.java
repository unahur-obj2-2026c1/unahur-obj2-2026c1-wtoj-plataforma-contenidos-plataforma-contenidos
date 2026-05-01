package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.planes.PlanStrategy;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

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

    public void actualizaCostoPlan(PlanStrategy plan, Double valor){
        plan.actualizaCostoPlan(valor);
    }
}