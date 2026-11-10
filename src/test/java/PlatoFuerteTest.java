import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatoFuerteTest {

    PlatoFuerte plato = new PlatoFuerte(201, "Bandeja Paisa", "Plato típico", 25000, 30, 500, true, TipoPreparacion.ASADO);

    @Test
    void calcularRecargoTest() {
        double recargo = plato.calcularValorFinal(plato);
        assertEquals(24000.0, recargo, 0.001);
    }

    @Test
    void verificarCalidadPlatoFuerteTest() {
        assertTrue(plato.verificarCalidadPlatoFuerte(500, 30, true));
    }

    @Test
    void verificarCalidadPlatoFuerteInvalidoTest() {
        assertFalse(plato.verificarCalidadPlatoFuerte(100, 70, false));
    }

    @Test
    void getPesoTest() {
        assertEquals(500.0, plato.getPeso(), 0.001);
    }
}