package ar.edu.unahur.obj2.w2j.planes;

import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public interface PlanStrategy {
    Double costoPlan(Usuario usuario);
    void actualizaCostoPlan(Double nuevoValor);
}