public class Postre extends Producto{
    private double peso;
    private int temperaturaAlmacenamiento;
    private boolean esRefrigerado;

    public Postre(int codigo, String nombre, String descripcion, double precioBase, double tiempoPreparacion, double peso, int temperaturaAlmacenamiento, boolean esRefrigerado) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.peso = peso;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.esRefrigerado = esRefrigerado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public void setTemperaturaAlmacenamiento(int temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public boolean isEsRefrigerado() {
        return esRefrigerado;
    }

    public void setEsRefrigerado(boolean esRefrigerado) {
        this.esRefrigerado = esRefrigerado;
    }

    @Override
    public String toString() {
        return "Postre\n" +
                super.toString()+
                "Peso: " + peso + " g"+
                ", Temperatura de almacenamiento: " + temperaturaAlmacenamiento + "°"+
                ", Es refrigerado: " + esRefrigerado;
    }

    @Override
    public double calcularRecargo() {
        return 0;
    }

    @Override
    public boolean verificarCalidadProducto() {
        return false;
    }
}
