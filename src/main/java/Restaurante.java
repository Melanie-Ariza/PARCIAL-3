import java.util.ArrayList;
import java.util.List;
public class Restaurante {
    private String nombre;
    private int nit;
    private String direccion;

    // Listas para gestionar el sistema
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Pedido> listaPedidos;

    // Constructor completo
    public Restaurante(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
    }


    // metodo agrearcliente
    public boolean agregarCliente(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento() == cliente.getDocumento()) {
                return false;
            }
        }
        listaClientes.add(cliente);
        return true;
    }

    //metodo de agregarproducto
    public boolean agregarProducto(Producto producto) {
        for (Producto p : listaProductos) {
            if (p.getCodigo() == producto.getCodigo()) {
                return false;
            }
        }
        listaProductos.add(producto);
        return true;
    }

    //metodo de agregarpedido
    public boolean agregarPedido(Pedido pedido) {
        for (Pedido p : listaPedidos) {
            if (p.getCodigo() == pedido.getCodigo()) {
                return false;
            }
        }
        listaPedidos.add(pedido);
        return true;
    }
    //Calcular ingresos totales sin pedidos cancelados o pendientes
    public double calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstadoPedido() != EstadoPedido.CANCELADO &&
                    pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {

                for (DetalleCompra detalle : pedido.getCompras()) {
                    ingresosTotales += detalle.getValorTotal();
                }
            }
        }
        return ingresosTotales;
    }

    // Calcular el producto más vendido
    public String obtenerProductoMasVendido() {
        if (listaProductos.isEmpty()) {
            return "No hay productos registrados en el menú.";
        }

        int maxCantidad = -1;
        String nombreMasVendido = "";
        int codigoMasVendido = -1;

        for (Producto producto : listaProductos) {
            int conteoVentas = 0;

            for (Pedido pedido : listaPedidos) {
                if (pedido.getEstadoPedido() != EstadoPedido.CANCELADO) {
                    for (DetalleCompra detalle : pedido.getCompras()) {
                        if (detalle.getProducto() != null &&
                                detalle.getProducto().getCodigo() == producto.getCodigo()) {
                            conteoVentas += detalle.getCantidad();
                        }
                    }
                }
            }

            if (conteoVentas > maxCantidad && conteoVentas > 0) {
                maxCantidad = conteoVentas;
                nombreMasVendido = producto.getNombre();
                codigoMasVendido = producto.getCodigo();
            }
        }

        if (maxCantidad > 0) {
            return "Producto más vendido: " + nombreMasVendido + " [Código: " + codigoMasVendido + "] con " + maxCantidad + " unidades.";
        } else {
            return "Aún no se han registrado ventas de productos en los pedidos.";
        }
    }

    // Categoría de producto con mayores ingresos
    public String determinarCategoriaMayorIngresos() {
        double ingresosPlatoFuerte = 0.0;
        double ingresosBebidas = 0.0;
        double ingresosPostres = 0.0;

        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstadoPedido() != EstadoPedido.CANCELADO &&
                    pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {

                for (DetalleCompra detalle : pedido.getCompras()) {
                    Producto producto = detalle.getProducto();
                    if (producto != null) {
                        double valorDetalle = detalle.getValorTotal();

                        if (producto instanceof PlatoFuerte) {
                            ingresosPlatoFuerte += valorDetalle;
                        } else if (producto instanceof Bebida) {
                            ingresosBebidas += valorDetalle;
                        } else if (producto instanceof Postre) {
                            ingresosPostres += valorDetalle;
                        }
                    }
                }
            }
        }

        if (ingresosPlatoFuerte == 0 && ingresosBebidas == 0 && ingresosPostres == 0) {
            return "Ninguna (Aún no hay ventas registradas)";
        }

        if (ingresosPlatoFuerte >= ingresosBebidas && ingresosPlatoFuerte >= ingresosPostres) {
            return "Plato Fuerte (Ingresos: $" + ingresosPlatoFuerte + ")";
        } else if (ingresosBebidas >= ingresosPlatoFuerte && ingresosBebidas >= ingresosPostres) {
            return "Bebidas (Ingresos: $" + ingresosBebidas + ")";
        } else {
            return "Postres (Ingresos: $" + ingresosPostres + ")";
        }
    }
    

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getNit() {return nit;}

    public void setNit(int nit) {this.nit = nit;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public List<Cliente> getListaClientes() {return listaClientes;}

    public List<Producto> getListaProductos() {return listaProductos;}

    public List<Pedido> getListaPedidos() {return listaPedidos;}
}
