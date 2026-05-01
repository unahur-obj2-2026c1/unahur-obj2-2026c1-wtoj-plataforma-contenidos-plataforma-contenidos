package ar.edu.unahur.obj2.w2j.planes;

import java.util.List;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public abstract class SPlanLimitado implements PlanStrategy {
    protected Integer limite;
    protected static Double costoBase = 5.0;
    
    public SPlanLimitado(Integer limite) {
        this.limite = limite;
    }

    // Template Method
    @Override
    public Double costoPlan(Usuario usuario) {
        List<Contenido> contenidos = usuario.getContenidos();
        Double costoExcedentes = contenidos.stream()
            .skip(limite) // saltea los primeros 'limite' elementos del stream (los incluidos en el plan) y deja solo los excedentes
            .mapToDouble(Contenido::getCostoBase) // esta es la forma moderna del closure
            .sum();
        
        Double total = costoBase + costoExcedentes;
        
        return aplicarAjuste(total);
    }

    // Accede al mismo costoBase para todas las instancias
    public static Double getCostoBase() {
        return costoBase;
    }

    // Modifica el costoBase para todas las instancias
    public static void setCostoBase(Double costoBase) {
        SPlanLimitado.costoBase = costoBase;
    }

    // Hook del Template
    protected abstract Double aplicarAjuste(Double total);

    @Override
    public void actualizaCostoPlan(Double nuevoValor) {
        SPlanLimitado.costoBase = nuevoValor;
    }

}
