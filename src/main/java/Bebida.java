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
    public double calcularRecargo(double precioBase) {

        return precioBase * 1.10;
    }

    public double calcularRecargoEspecial(boolean esEspecial, double precioRecargo){
        double recargoEspecial= 0;
        if (esEspecial){
            recargoEspecial= precioRecargo + 3000;
        }
        return recargoEspecial;
    }

    public boolean verificarCalidadBebida(TipoBebida tipoBebida, double volumen, int temperaturaServicio) {
        boolean esDeCalidad= false;
        if (tipoBebida == TipoBebida.FRIA){
            if (volumen>=150 && volumen<=1500 && temperaturaServicio>=0 && temperaturaServicio<=10){
                esDeCalidad=true;
            }
        } else if (tipoBebida == TipoBebida.CALIENTE) {
            if (volumen>=150 && volumen<=1500 && temperaturaServicio>=55 && temperaturaServicio<=85){
                esDeCalidad=true;
            }
        }
        return esDeCalidad;
    }
}
