package ar.edu.unahur.obj2.w2j.contenidos;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private final Integer numero;
    private List<Episodio> episodios = new ArrayList<>();

    public Temporada(Integer numero) {
        this.numero = numero;
    }

    public Temporada(Integer numero, List<Episodio> episodios) {
        this.numero = numero;
        this.episodios = new ArrayList<>(episodios); // Es mas adecuado una copia defensiva que solo episodios;
    }

    public void agregarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    public Integer getNumero() {
        return numero;
    }

    public List<Episodio> getEpisodios() {
        return List.copyOf(episodios); // Para no exponer la lista interna (mutable)
    }

    public Double costo() {
        return episodios.stream()
                .mapToDouble(e -> e.getCosto()) // Version moderna .mapToDouble(Episodio::getCosto)
                .average()
                .orElse(0.0);
        // Promedio de esta temporada, no de toda la serie
    }

}
