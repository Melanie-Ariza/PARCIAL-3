import java.util.ArrayList;
import java.util.List;

public class DetalleCompra {
    private double valorTotal;
    private List<Producto> productos;

    public DetalleCompra(double valorTotal) {
        this.valorTotal = valorTotal;
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //Hacer método de valor total

    @Override
    public String toString() {
        return "DetalleCompra: " +
                "valorTotal: " + valorTotal+
                ", productos: " + productos;
    }
}
