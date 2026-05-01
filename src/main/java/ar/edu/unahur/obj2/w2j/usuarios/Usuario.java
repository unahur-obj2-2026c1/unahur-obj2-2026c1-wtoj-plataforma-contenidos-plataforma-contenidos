package ar.edu.unahur.obj2.w2j.usuarios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.planes.PlanStrategy;
import ar.edu.unahur.obj2.w2j.planes.SPlanBasico;

public class Usuario {
    private PlanStrategy plan = new SPlanBasico(10);
    private List<Contenido> contenidos = new ArrayList<>();

    public Usuario(PlanStrategy plan, List<Contenido> contenidos) {
        this.plan = plan;
        this.contenidos = contenidos;
    }

    public Usuario() {
    }

    public Usuario(PlanStrategy plan) {
        this.plan = plan;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void verContenido(Contenido contenido) {
        contenidos.add(contenido);
    }

    public PlanStrategy getPlan() {
        return plan;
    }

    public void setPlan(PlanStrategy plan) {
        this.plan = plan;
    }

    public void limpiarContenidos() {
        contenidos.clear();
    }

    public Double costoMensual() {
        return plan.costoPlan(this);
    }
}