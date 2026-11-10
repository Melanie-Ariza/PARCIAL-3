import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClienteTest {

    Cliente cliente = new Cliente(12345, "Carlos Pérez", "3001234567", "carlos@gmail.com", "Calle 10 #15-20");

    // 1. Probar que el cliente tenga los datos iniciales correctos
    @Test
    void probarClienteDatosCorrectos() {
        assertEquals(12345, cliente.getDocumento());
        assertEquals("Carlos Pérez", cliente.getNombre());
        assertEquals("3001234567", cliente.getTelefono());
        assertEquals("carlos@gmail.com", cliente.getCorreo());
        assertEquals("Calle 10 #15-20", cliente.getDireccion());
    }

    // 2. Verificar que el correo contenga arroba
    @Test
    void correoDebeContenerArroba() {
        assertTrue(cliente.getCorreo().contains("@"));
    }

    // 3. Probar que la lista de pedidos se inicialice no nula
    @Test
    void listaPedidosNoDebeSerNula() {
        assertNotNull(cliente.getPedidos());
    }

    // 4. Probar que la lista de pedidos inicie vacía
    @Test
    void listaPedidosDebeIniciarVacia() {
        assertTrue(cliente.getPedidos().isEmpty());
    }

    // 5. Probar actualización del correo mediante el setter
    @Test
    void actualizarCorreoCorrectamente() {
        cliente.setCorreo("carlos.nuevo@gmail.com");
        assertEquals("carlos.nuevo@gmail.com", cliente.getCorreo());
    }

}