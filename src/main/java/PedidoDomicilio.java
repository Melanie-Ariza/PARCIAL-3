import java.sql.Date;

public class PedidoDomicilio extends Pedido {
    private double distancia;

    public PedidoDomicilio(int codigo, Date fecha, EstadoPedido estadoPedido, double distancia) {
        super(codigo, fecha, estadoPedido);
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "PedidoDomicilio: " + super.toString()+
                ", distancia: " + distancia;
    }
}
