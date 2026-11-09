import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int codigo;
    private Date fecha;
    private EstadoPedido estadoPedido;
    private List<DetalleCompra> compras;


    public Pedido(int codigo, Date fecha, EstadoPedido estadoPedido) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.compras = new ArrayList<>();
    }
    public List<DetalleCompra> getCompras() {return compras;}

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedido: " +"\n"+
                "codigo: " + codigo +
                ", fecha: " + fecha +
                ", estadoPedido: " + estadoPedido+
                ", compras: " + compras;
    }
}
