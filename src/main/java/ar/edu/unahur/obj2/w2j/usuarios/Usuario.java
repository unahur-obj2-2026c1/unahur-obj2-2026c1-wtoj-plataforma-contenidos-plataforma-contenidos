package ar.edu.unahur.obj2.w2j.usuarios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.planes.IPlan;
import ar.edu.unahur.obj2.w2j.planes.PlanBasico;

public class Usuario {
    private IPlan plan = new PlanBasico(10);
    private List<Contenido> contenidos = new ArrayList<>();

    public Usuario(IPlan plan, List<Contenido> contenidos) {
        this.plan = plan;
        this.contenidos = contenidos;
    }

    public Usuario() {}

    public Usuario(IPlan plan) {
        this.plan = plan;
    }

    public List<Contenido> getContenidos() {
        return contenidos;    }

    public void verContenido(Contenido contenido) {
        contenidos.add(contenido);
    }

    public IPlan getPlan() {
        return plan;
    }

    public void setPlan(IPlan plan) {
        this.plan = plan;
    }

    public Double costoMensual() {
        return plan.costoPlan(this);
    }
}