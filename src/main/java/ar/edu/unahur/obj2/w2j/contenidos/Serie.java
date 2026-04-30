package ar.edu.unahur.obj2.w2j.contenidos;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {

    private List<Temporada> temporadas = new ArrayList<>();

    public Serie(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public Double doCosto() {

        return temporadas.stream() // convierte la lista de temporadas en un stream para procesarlas 
                .flatMap(t -> t.getEpisodios().stream()) // aplana: pasa de "temporadas con listas de episodios" a "todos los episodios juntos"
                .mapToDouble(Episodio::getCosto) // transforma cada episodio en su costo (double)
                .average() // calcula el promedio de todos los costos
                .orElse(0.0); // si no hay episodios, devuelve 0 para evitar vacío
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }
}