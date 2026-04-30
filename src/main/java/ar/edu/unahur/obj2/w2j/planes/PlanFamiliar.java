package ar.edu.unahur.obj2.w2j.planes;

import java.util.List;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public class PlanFamiliar implements IPlan {
    private Integer limite;
    private Double costoBase = 5.0;
    private Double descuento = 0.15;

    public PlanFamiliar(Integer limite) {
        this.limite = limite;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        List<Contenido> contenidos = usuario.getContenidos();
        Double costoExcedentes = contenidos.stream()
            .skip(limite) // saltea los primeros 'limite' elementos del stream (los incluidos en el plan) y deja solo los excedentes
            .mapToDouble(Contenido::getCostoBase) // esta es la forma moderna del closure
            .sum();

        return (this.costoBase + costoExcedentes) * (1 - descuento);
    }
}