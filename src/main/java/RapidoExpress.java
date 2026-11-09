public class RapidoExpress implements IEmpresaTransporte {
    //Constantes
    public static final double TARIFA_BASE = 5000.0;
    public static final double COSTO_KILOMETRO = 1500.0;
    public static final double LIMITE_KILOMETROS = 12.0;

    @Override
    public double calcularCosto(double distancia) {
        //límite de la empresa
        if (distancia > LIMITE_KILOMETROS) {
            System.out.println(">> Rápido Express no realiza domicilios a más de " + LIMITE_KILOMETROS + " km.");
            return 0.0;
        }

        return TARIFA_BASE + (distancia * COSTO_KILOMETRO);
    }
}

