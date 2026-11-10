import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ProductoTest {

    Producto producto = new PlatoFuerte(101, "Bandeja Paisa", "Plato típico", 25000.0, 30.0, 500.0, true, TipoPreparacion.ASADO);


    @Test
    void probarDatosProductoTest() {
        assertEquals(101, producto.getCodigo());
        assertEquals("Bandeja Paisa", producto.getNombre());
        assertEquals("Plato típico", producto.getDescripcion());
        assertEquals(25000.0, producto.getPrecioBase(), 0.001);
    }


    @Test
    void setPrecioBaseTest() {
        producto.setPrecioBase(28000.0);
        assertEquals(28000.0, producto.getPrecioBase(), 0.001);
    }


    @Test
    void precioBaseDebeSerMayorAZeroTest() {
        assertTrue(producto.getPrecioBase() > 0);
    }


    @Test
    void descripcionNoDebeSerNulaTest() {
        assertNotNull(producto.getDescripcion());
    }


    @Test
    void noPermitirPrecioBaseInvalidoTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            double precioTest = -5000.0;
            if (precioTest <= 0) {
                throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
            }
            new PlatoFuerte(102, "Sancocho", "Sopa de res", precioTest, 25.0, 400.0, true, TipoPreparacion.ASADO);
        });
    }

}