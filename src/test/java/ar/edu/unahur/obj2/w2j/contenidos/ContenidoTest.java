package ar.edu.unahur.obj2.w2j.contenidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.planes.PlanBasico;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public class ContenidoTest {
    @Test
    void dadaUnaSerieConVariasTemporadas_cuandoCalculoCosto_entoncesPromediaTodosLosEpisodios() {
        Serie serie = new Serie("Serie", 1.0);

        Temporada t1 = new Temporada(1);
        t1.agregarEpisodio(new Episodio("E1", 1, 10.0));
        t1.agregarEpisodio(new Episodio("E2", 2, 10.0));

        Temporada t2 = new Temporada(2);
        t2.agregarEpisodio(new Episodio("E3", 1, 1.0));

        serie.agregarTemporada(t1);
        serie.agregarTemporada(t2);

        assertEquals(8.0, serie.costo()); // 1 + promedio(10,10,1)
    }

    @Test
    void dadoUnDocumental_cuandoCambioCanonIDRA_entoncesImpactaEnElCosto() {
        IDRA.getInstance().setValor(2.0);

        Documental doc = new Documental("Doc", 1.0);

        assertEquals(3.0, doc.costo());
    }

    @Test
    void dadoUnUsuarioConContenidos_cuandoLimpiaConsumo_entoncesQuedaSinContenidos() {
        Usuario usuario = new Usuario(new PlanBasico(2));

        usuario.verContenido(new Pelicula("P1", 2.0));

        usuario.limpiarContenidos();

        assertEquals(0, usuario.getContenidos().size());
    }

}
