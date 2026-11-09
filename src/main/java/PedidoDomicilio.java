import java.sql.Date;

public class PedidoDomicilio extends Pedido {
    private double distancia;
    private IEmpresaTransporte iEmpresaTransporte;

    public PedidoDomicilio(int codigo, Date fecha, EstadoPedido estadoPedido, double distancia, IEmpresaTransporte iEmpresaTransporte) {
        super(codigo, fecha, estadoPedido);
        this.distancia = distancia;
        this.iEmpresaTransporte = iEmpresaTransporte;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public IEmpresaTransporte getiEmpresaTransporte() {
        return iEmpresaTransporte;
    }

    public void setiEmpresaTransporte(IEmpresaTransporte iEmpresaTransporte) {
        this.iEmpresaTransporte = iEmpresaTransporte;
    }

    @Override
    public String toString() {
        return "Pedido Domicilio\n" +
                super.toString()+
                ", Distancia: " + distancia+
                ", Empresa transporte: "+ iEmpresaTransporte;
    }
}
