import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RestauranteTest {
    Restaurante restaurante = new Restaurante("El Sazón", 900123, "Carrera 5 #10-00");
    Cliente cliente1 = new Cliente(1001, "Mario Rossi", "3111234567", "mario@gmail.com", "Calle 2");
    Cliente clienteDuplicado = new Cliente(1001, "Luigi Rossi", "3229876543", "luigi@gmail.com", "Calle 3");
    PlatoFuerte plato1 = new PlatoFuerte(10, "Carne Asada", "Corte fino", 15000.0, 20.0, 300.0, true, TipoPreparacion.ASADO);

    // 1. Permitir agregar un cliente nuevo exitosamente
    @Test
    void agregarClienteExitosamente() {
        assertTrue(restaurante.agregarCliente(cliente1));
    }

    // 2. No permitir clientes con documento duplicado
    @Test
    void noDebePermitirClienteDuplicado() {
        restaurante.agregarCliente(cliente1);
        assertFalse(restaurante.agregarCliente(clienteDuplicado));
    }

    // 3. Permitir agregar un producto nuevo exitosamente
    @Test
    void agregarProductoExitosamente() {
        assertTrue(restaurante.agregarProducto(plato1));
    }

    // 4. Los ingresos totales iniciales deben ser cero si no hay ventas
    @Test
    void ingresosTotalesDebenSerCeroSinVentas() {
        assertEquals(0.0, restaurante.calcularIngresosTotales());
    }

    // 5. Las listas internas del restaurante no deben ser nulas
    @Test
    void listasRestauranteNoDebenSerNulas() {
        assertNotNull(restaurante.getListaClientes());
        assertNotNull(restaurante.getListaProductos());
        assertNotNull(restaurante.getListaPedidos());
    }

}