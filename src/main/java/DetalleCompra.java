public class DetalleCompra {
    private double valorTotal;

    public DetalleCompra(double valorTotal) {
        this.valorTotal = valorTotal;
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
                "valorTotal: " + valorTotal;
    }
}
