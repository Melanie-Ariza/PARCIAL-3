public abstract class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private double tiempoPreparacion;

    public Producto(int codigo, String nombre, String descripcion, double precioBase, double tiempoPreparacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(double tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return  "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Descripción: " + descripcion +
                ", Precio base: " + precioBase +
                ", Tiempo de preparacion: " + tiempoPreparacion;
    }

    public abstract double calcularRecargo(double precioBase);
}
