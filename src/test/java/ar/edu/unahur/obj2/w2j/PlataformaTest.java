package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.planes.*;
import ar.edu.unahur.obj2.w2j.usuarios.Usuario;

public class PlataformaTest {
    @Test
    void dadaUnaPlataforma_cuandoTengoDosUsuarios_entoncesCalculaFacturacionTotal() {
        Plataforma plataforma = Plataforma.getIntance();

        Usuario u1 = new Usuario(new SPlanPremium(10.0));
        Usuario u2 = new Usuario(new SPlanPremium(20.0));

        plataforma.agregarUsuario(u1);
        plataforma.agregarUsuario(u2);

        assertEquals(30.0, plataforma.facturacionMensual());
    }

    private Double costoOriginal;

    @BeforeEach
    void setUp() {
        costoOriginal = SPlanLimitado.getCostoBase();
    }

    @AfterEach
    void tearDown() {
        SPlanLimitado.setCostoBase(costoOriginal);
    }

    @Test
    void dadoUnPlanLimitado_cuandoSeActualizaElCostoBase_entoncesCambiaEnTodasLasInstancias() {
        Plataforma plataforma = Plataforma.getIntance();
        SPlanLimitado planFamiliar = new SPlanFamiliar(10);
        SPlanLimitado planBasico = new SPlanBasico(10);

        Usuario uBasico = new Usuario(planBasico);

        plataforma.actualizaCostoPlan(planBasico, 11.6);
        plataforma.actualizaCostoPlan(planFamiliar, 8.3);

        assertEquals(8.3, planBasico.costoPlan(uBasico));
    }

}
