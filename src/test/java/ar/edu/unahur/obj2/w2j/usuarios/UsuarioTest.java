package ar.edu.unahur.obj2.w2j.usuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.contenidos.Pelicula;
import ar.edu.unahur.obj2.w2j.planes.SPlanBasico;
import ar.edu.unahur.obj2.w2j.planes.SPlanFamiliar;
import ar.edu.unahur.obj2.w2j.planes.SPlanPremium;

public class UsuarioTest {
    @Test
    void dadoUnUsuarioConPlanBasico_cuandoNoSuperaElLimite_entoncesPagaSoloCostoFijo() {
        Usuario usuario = new Usuario(new SPlanBasico(3));

        usuario.verContenido(new Pelicula("P1", 2.0));
        usuario.verContenido(new Pelicula("P2", 3.0));

        assertEquals(5.0, usuario.costoMensual());
    }

    @Test
    void dadoUnUsuarioConPlanBasico_cuandoSuperaElLimite_entoncesPagaCostoFijoMasExcedentes() {
        Usuario usuario = new Usuario(new SPlanBasico(2));

        usuario.verContenido(new Pelicula("P1", 2.0));
        usuario.verContenido(new Pelicula("P2", 3.0));
        usuario.verContenido(new Pelicula("P3", 4.0));

        assertEquals(9.0, usuario.costoMensual()); // 5 + 4
    }

    @Test
    void dadoUnUsuarioConPlanFamiliar_cuandoSuperaElLimite_entoncesAplicaDescuentoAlTotal() {
        Usuario usuario = new Usuario(new SPlanFamiliar(2));

        usuario.verContenido(new Pelicula("P1", 2.0));
        usuario.verContenido(new Pelicula("P2", 3.0));
        usuario.verContenido(new Pelicula("P3", 4.0));

        Double esperado = (5.0 + 4.0) * 0.85;

        assertEquals(esperado, usuario.costoMensual());
    }

    @Test
    void dadoUnUsuarioConPlanPremium_cuandoConsumeContenido_entoncesPagaSiempreMontoFijo() {
        Usuario usuario = new Usuario(new SPlanPremium(12.0));

        usuario.verContenido(new Pelicula("P1", 2.0));
        usuario.verContenido(new Pelicula("P2", 10.0));

        assertEquals(12.0, usuario.costoMensual());
    }

}
