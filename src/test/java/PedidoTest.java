import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

        Pedido pedido = new Pedido(1, Date.valueOf("2026-11-09"), EstadoPedido.PENDIENTE);

        @Test
        void getCodigoTest() {
            assertEquals(1, pedido.getCodigo());
        }

        @Test
        void setEstadoPedidoTest() {
            pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
            assertEquals(EstadoPedido.ENTREGADO, pedido.getEstadoPedido());
        }

        @Test
        void getComprasVacioTest() {
            assertNotNull(pedido.getCompras());
            assertTrue(pedido.getCompras().isEmpty());
        }

        @Test
        void getFechaTest() {
            assertEquals(Date.valueOf("2026-11-09"), pedido.getFecha());
        }
}

