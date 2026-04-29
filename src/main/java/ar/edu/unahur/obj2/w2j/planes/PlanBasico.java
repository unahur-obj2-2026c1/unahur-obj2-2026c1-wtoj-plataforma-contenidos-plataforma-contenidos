package ar.edu.unahur.obj2.w2j.planes;

import java.util.List;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public class PlanBasico  implements IPlan{
    private Integer limite;

    public PlanBasico(Integer limite) {
        this.limite = limite;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        Double costoBase = 5.0;
        List<Contenido> contenidos = usuario.getContenidos();
        if (limite >= contenidos.size()) {
            return costoBase;
        } else  {
            List<Contenido> excedentes = contenidos.subList(limite,contenidos.size());
            return costoBase + excedentes.stream().mapToDouble(c -> c.costo()).sum();
        }
    }



    

}