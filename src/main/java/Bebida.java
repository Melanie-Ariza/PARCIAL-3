public class Bebida extends Producto{
    private double volumen;
    private double temperaturaServicio;
    private boolean esEspecial;
    TipoBebida tipoBebida;

    public Bebida(int codigo, String nombre, String descripcion, double precioBase, double tiempoPreparacion, double volumen, double temperaturaServicio, boolean esEspecial, TipoBebida tipoBebida) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.volumen = volumen;
        this.temperaturaServicio = temperaturaServicio;
        this.esEspecial = esEspecial;
        this.tipoBebida = tipoBebida;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public void setTemperaturaServicio(double temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    @Override
    public String toString() {
        return "Bebidas\n" +
                super.toString()+
                "Volumen: " + volumen + " ml"+
                ", Temperatura servicio: " + temperaturaServicio + "°"+
                ", Es especial:" + esEspecial+
                ", Tipo bebida: "+tipoBebida;
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
