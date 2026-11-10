public class PlatoFuerte extends Producto{
    private double peso;
    private boolean controlCoccion;
    TipoPreparacion tipoPreparacion;

    public PlatoFuerte(int codigo, String nombre, String descripcion, double precioBase, double tiempoPreparacion, double peso, boolean controlCoccion, TipoPreparacion tipoPreparacion) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.peso = peso;
        this.controlCoccion = controlCoccion;
        this.tipoPreparacion = tipoPreparacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean getControlCoccion() {
        return controlCoccion;
    }

    public void setControlCoccion(boolean controlCoccion) {
        this.controlCoccion = controlCoccion;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }

    @Override
    public String toString() {
        return "Plato Fuerte\n" +
                super.toString()+
                "Peso: " + peso + " g"+
                ", Control cocción: " + controlCoccion+
                ", Tipo preparación: "+tipoPreparacion;
    }

    @Override
    public double calcularValorFinal(Producto producto) {
        double precioBase= producto.getPrecioBase();
        return precioBase * 1.20;
    }

    public boolean verificarCalidadPlatoFuerte(double peso, double tiempoPreparacion, boolean controlCoccion) {
        boolean esDeCalidad= false;
        if (peso>=200 && peso<=900 && tiempoPreparacion>=10 && tiempoPreparacion<=60 && controlCoccion){
            esDeCalidad=true;
        }
        return esDeCalidad;
    }
}
