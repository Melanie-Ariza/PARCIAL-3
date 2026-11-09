public class DetalleCompra {

    private double valorTotal;
    private Producto producto;
    private int cantidad;

    public DetalleCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        if (producto != null) {
            this.valorTotal = producto.calcularRecargo(producto.getPrecioBase()) * cantidad;
        } else {
            this.valorTotal = 0.0;
        }
    }

    public DetalleCompra(double valorTotal) {
        this.valorTotal = valorTotal;
        this.cantidad = 1;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        if (producto != null) {
            this.valorTotal = producto.calcularRecargo(producto.getPrecioBase()) * this.cantidad;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        if (this.producto != null) {
            this.valorTotal = this.producto.calcularRecargo(this.producto.getPrecioBase()) * cantidad;
        }
    }

    @Override
    public String toString() {
        String nombreProd = (producto != null) ? producto.getNombre() : "Sin producto";
        return "DetalleCompra: " + nombreProd + " x" + cantidad + " | valorTotal: $" + valorTotal;
    }
}