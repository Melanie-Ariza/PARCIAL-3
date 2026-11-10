import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostreTest {

    Postre postre = new Postre(231, "Tarta de Fresa", "Sabor Dulce y ácido", 13000, 120, 90, 3, true);

    @Test
    void noDebePermitirProductosSinCalidad() {
        assertTrue(postre.getPeso() > 80 && postre.getPeso() < 500);
        assertTrue(postre.getTemperaturaAlmacenamiento() > 0 && postre.getTemperaturaAlmacenamiento() < 6 || postre.getTemperaturaAlmacenamiento() > 15 && postre.getTemperaturaAlmacenamiento() < 60);
    }

    @Test
    void calcularRecargoTest() {
        double recargo = postre.calcularValorFinal(postre);
        assertEquals(11500.0, recargo, 0.001);
    }

    @Test
    void calcularRecargoRefrigeradoTest() {
        double recargo = postre.calcularRecargoRefrigerado(true, 10000);
        assertEquals(12000.0, recargo, 0.001);
    }

    @Test
    void calcularRecargoRefrigeradoFalsoTest() {
        double recargo = postre.calcularRecargoRefrigerado(false, 10000);
        assertEquals(0.0, recargo, 0.001);


    }
}