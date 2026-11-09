public class EntregaSegura implements IEmpresaTransporte{
    //Constantes
    public static final double TARIFA_BASE = 7000.0;
    public static final double COSTO_KILOMETRO = 1000.0;
    public static final double RECARGO_5KM = 3000.0;
    public static final double LIMITE_KILOMETROS = 20.0;

    @Override
    public double calcularCosto(double distancia) {
        //límite de la empresa
        if (distancia > LIMITE_KILOMETROS) {
            System.out.println(">> Entrega Segura no realiza domicilios a más de " + LIMITE_KILOMETROS + " km.");
            return 0.0;
        }

        double costoTotal = TARIFA_BASE + (distancia * COSTO_KILOMETRO);

        //Si pasa los 5 km se le añade el recargo especial de $3k
        if (distancia > 5.0) {
            costoTotal += RECARGO_5KM;
        }

        return costoTotal;
    }
}
