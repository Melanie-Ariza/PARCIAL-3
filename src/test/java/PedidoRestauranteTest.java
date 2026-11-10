import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;

class PedidoRestauranteTest {

    Date fechaActual = new Date(System.currentTimeMillis());
    PedidoRestaurante pedido = new PedidoRestaurante(501, fechaActual, EstadoPedido.PENDIENTE);

    // 1. Probar que los datos iniciales del pedido se guarden bien
    @Test
    void probarDatosInicialesPedido() {
        assertEquals(501, pedido.getCodigo());
        assertEquals(fechaActual, pedido.getFecha());
        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
    }

    // 2. Probar que la lista de compras inicie no nula
    @Test
    void listaComprasNoDebeSerNula() {
        assertNotNull(pedido.getCompras());
    }

    // 3. Probar que el pedido inicie sin compras registradas
    @Test
    void listaComprasDebeIniciarVacia() {
        assertTrue(pedido.getCompras().isEmpty());
    }

    // 4. Probar la actualización del estado del pedido
    @Test
    void cambiarEstadoPedido() {
        pedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
        assertEquals(EstadoPedido.CONFIRMADO, pedido.getEstadoPedido());
    }

    // 5. Verificar que el estado del pedido haya cambiado y no sea más PENDIENTE
    @Test
    void estadoPedidoNoDebeSerPendienteAlConfirmar() {
        pedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
        assertNotEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
    }

}