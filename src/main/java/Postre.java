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
    public double calcularRecargo(double precioBase) {
        return precioBase * 1.15;
    }

    public double calcularRecargoRefrigerado(boolean esRefrigerado, double precioBase){
        double recargoRefrigerado= 0;
        if (esRefrigerado){
            recargoRefrigerado= precioBase * 1.20;
        }
        return recargoRefrigerado;
    }

    public boolean verificarCalidadPostre(double peso, int temperaturaAlmacenamiento, boolean controlCoccion) {
        boolean esDeCalidad= false;
        if (esRefrigerado){
            if (peso>=80 && peso<=500 && temperaturaAlmacenamiento>=0 && temperaturaAlmacenamiento<=6){
                esDeCalidad=true;
            }
        } else{
            if (peso>=80 && peso<=500 && temperaturaAlmacenamiento>=15 && temperaturaAlmacenamiento<=30){
                esDeCalidad=true;
            }
        }
        return esDeCalidad;
    }

}
