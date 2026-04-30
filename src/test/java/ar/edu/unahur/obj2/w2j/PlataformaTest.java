package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.planes.PlanPremium;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public class PlataformaTest {
    @Test
    void dadaUnaPlataforma_cuandoTengoDosUsuarios_entoncesCalculaFacturacionTotal() {
        Plataforma plataforma = Plataforma.getIntance();

        Usuario u1 = new Usuario(new PlanPremium(10.0));
        Usuario u2 = new Usuario(new PlanPremium(20.0));

        plataforma.agregarUsuario(u1);
        plataforma.agregarUsuario(u2);

        assertEquals(30.0, plataforma.facturacionMensual());
    }
}
