package ar.edu.unahur.obj2.w2j.contenido;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {

    private List<Temporada> temporadas = new ArrayList<>();

    public Serie(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    @Override
    public Double doCosto() {
        return temporadas.stream().mapToDouble(t -> t.costo()).average().orElse(0.0);
 }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }
}