import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;

class BebidaTest {

    Bebida bebida = new Bebida(101, "Jugo de Mora", "Natural y fresco", 5000, 10, 300, 5, true, TipoBebida.FRIA);

    @Test
    void calcularRecargoTest() {
        double recargo = bebida.calcularRecargo(10000);
        assertEquals(11000.0, recargo, 0.001);
    }

    @Test
    void calcularRecargoEspecialTest() {
        double recargo = bebida.calcularRecargoEspecial(true, 5000);
        assertEquals(8000.0, recargo, 0.001);
    }

    @Test
    void calcularRecargoEspecialFalsoTest() {
        double recargo = bebida.calcularRecargoEspecial(false, 5000);
        assertEquals(0.0, recargo, 0.001);
    }

    @Test
    void verificarCalidadBebidaFriaTest() {
        assertTrue(bebida.verificarCalidadBebida(TipoBebida.FRIA, 300, 5));
    }
}