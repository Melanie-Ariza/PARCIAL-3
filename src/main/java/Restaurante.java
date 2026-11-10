import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private String nombre;
    private int nit;
    private String direccion;

    // Listas para gestionar el sistema
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Pedido> listaPedidos;

    public Restaurante(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Restaurante\n" +
                "Nombre: " + nombre +
                ", NIT: " + nit +
                ", Dirección" + direccion +
                ", Lista clientes:" + listaClientes +
                ", Lista productos:" + listaProductos +
                ", Lista pedidos:" + listaPedidos;
    }

    // metodo agrearcliente
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado= true;
        for (Cliente c : listaClientes) {
            if (c.getDocumento() == cliente.getDocumento()) {
                agregado= false;
            }
        }
        listaClientes.add(cliente);
        return agregado;
    }

    //metodo mostrar cliente
    public Cliente mostrarCliente(int documento){
        Cliente cliente= null;
        for (Cliente cliente1: listaClientes){
            if (cliente1.getDocumento()== documento){
                cliente= cliente1;
            }
        }
        return  cliente;
    }

    //metodo de agregarproducto
    public boolean agregarProducto(Producto producto) {
        boolean agregado= true;
        for (Producto p : listaProductos) {
            if (p.getCodigo() == producto.getCodigo()) {
                agregado= false;
            }
        }
        listaProductos.add(producto);
        return agregado;
    }

    //metodo mostrar producto
    public Producto mostrarProducto(int codigo){
        Producto producto= null;
        for (Producto producto1: listaProductos){
            if (producto1.getCodigo()== codigo){
                producto= producto1;
            }
        }
        return  producto;
    }

    //metodo de agregar pedido
    public boolean agregarPedido(Pedido pedido) {
        boolean agregado= true;
        for (Pedido p : listaPedidos) {
            if (p.getCodigo() == pedido.getCodigo()) {
                agregado= false;
            }
        }
        listaPedidos.add(pedido);
        return agregado;
    }

    //metodo mostrar pedido
    public Pedido mostrarPedido(int codigo){
        Pedido pedido= null;
        for (Pedido pedido1: listaPedidos){
            if (pedido1.getCodigo()== codigo){
                pedido= pedido1;
            }
        }
        return  pedido;
    }

    //metodo actualizar estado pedido
    public boolean actualizarEstadoPedido(Pedido pedido, int opcionEstado){
        boolean actualizado=false;
        EstadoPedido estadoPedido= pedido.getEstadoPedido();
        if (opcionEstado==1){
            pedido.setEstadoPedido(EstadoPedido.PENDIENTE);
            actualizado=true;
        } else if (opcionEstado==2) {
            pedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
            actualizado=true;
        }else if (opcionEstado==3) {
            pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
            actualizado=true;
        }else if (opcionEstado==4) {
            pedido.setEstadoPedido(EstadoPedido.CANCELADO);
            actualizado=true;
        }
        return actualizado;
    }

    //Calcular ingresos totales sin pedidos cancelados o pendientes o el domicilio
    public double calcularIngresosTotales() {
        double ingresosTotales = 0;
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstadoPedido() != EstadoPedido.CANCELADO && pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {
                for (DetalleCompra detalle : pedido.getCompras()) {
                    ingresosTotales += detalle.calcularSubTotal();
                }
            }
        }
        return ingresosTotales;
    }

    // obtener el producto más vendido
    public String obtenerProductoMasVendido() {
        String mensaje="";
        if (listaProductos.isEmpty()) {
            mensaje= "No hay productos registrados en el menú.";
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
            mensaje= "Producto más vendido: " + nombreMasVendido + " [Código: " + codigoMasVendido + "] con " + maxCantidad + " unidades.";
        } else {
            mensaje= "Aún no se han registrado ventas de productos en los pedidos.";
        }
        return mensaje;
    }

    // Categoría de producto con mayores ingresos
    public String determinarCategoriaMayorIngresos() {
        String mensaje="";
        double ingresosPlatoFuerte = 0.0;
        double ingresosBebidas = 0.0;
        double ingresosPostres = 0.0;

        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstadoPedido() != EstadoPedido.CANCELADO &&
                    pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {

                for (DetalleCompra detalle : pedido.getCompras()) {
                    Producto producto = detalle.getProducto();
                    if (producto != null) {
                        double valorDetalle = detalle.calcularSubTotal();

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
            mensaje= "Ninguna (Aún no hay ventas registradas)";
        }

        if (ingresosPlatoFuerte >= ingresosBebidas && ingresosPlatoFuerte >= ingresosPostres) {
            mensaje=  "Plato Fuerte (Ingresos: $" + ingresosPlatoFuerte + ")";
        } else if (ingresosBebidas >= ingresosPlatoFuerte && ingresosBebidas >= ingresosPostres) {
            mensaje= "Bebidas (Ingresos: $" + ingresosBebidas + ")";
        } else {
            mensaje= "Postres (Ingresos: $" + ingresosPostres + ")";
        }
        return mensaje;
    }

    //Calcular valor total pedido
    public double calcularValorTotalPedido(int codigo){
        double valorTotal=0;
        double subTotal=0;

        for (Pedido pedido1: listaPedidos){
            if (pedido1.getCodigo()== codigo){
                for (DetalleCompra detalle: pedido1.getCompras()){
                    subTotal= detalle.calcularSubTotal();
                    valorTotal+=subTotal;
                }
            }
        }
        return valorTotal;
    }

    public void comenzarPedido(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        int opcion = 1;

        System.out.print("Ingrese código de pedido: ");
        int codigo = sc.nextInt();

        System.out.print("¿Es un pedido a domicilio? (1: Sí / 2: No): ");
        int tipoPedido = sc.nextInt();

        Pedido pedido;

        if (tipoPedido == 1) {
            System.out.print("Ingrese la distancia en km: ");
            double distancia = sc.nextDouble();

            System.out.println("Seleccione la empresa de transporte:");
            System.out.println("1. Rápido Express");
            System.out.println("2. Entrega Segura");
            int opcionEmpresa = sc.nextInt();

            IEmpresaTransporte empresaTransporte;
            if (opcionEmpresa == 1) {
                empresaTransporte = new RapidoExpress();
            } else {
                empresaTransporte = new EntregaSegura();
            }

            // Se instancia como PedidoDomicilio polimórficamente
            pedido = new PedidoDomicilio(codigo, Date.valueOf(LocalDate.now()), EstadoPedido.PENDIENTE, distancia, empresaTransporte);
        } else {
            pedido = new Pedido(codigo, Date.valueOf(LocalDate.now()), EstadoPedido.PENDIENTE);
        }

        do {
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }

            System.out.print("Ingrese el código del producto que desea: ");
            int codigoProducto = sc.nextInt();

            boolean encontrado = false;
            for (Producto producto : listaProductos) {
                if (producto.getCodigo() == codigoProducto) {
                    System.out.print("¿Qué cantidad desea?: ");
                    int cantidadDeseada = sc.nextInt();

                    DetalleCompra nuevoDetalle = new DetalleCompra(producto, cantidadDeseada);
                    pedido.getCompras().add(nuevoDetalle);

                    System.out.println("Hecho.");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado.");
            }

            System.out.println("¿Desea continuar comprando? (1: Sí / 2: No)");
            opcion = sc.nextInt();
        } while (opcion != 2);

        double valorFinal = 0;
        for (DetalleCompra detalle : pedido.getCompras()) {
            valorFinal += detalle.calcularSubTotal();
        }

        if (pedido instanceof PedidoDomicilio) {
            PedidoDomicilio pedidoDomicilio = (PedidoDomicilio) pedido;
            double costoDomicilio = pedidoDomicilio.getiEmpresaTransporte().calcularCosto(pedidoDomicilio.getDistancia());
            valorFinal += costoDomicilio;
            System.out.println("Costo del domicilio: " + costoDomicilio);
        }

        System.out.println("Valor total del pedido (con domicilio incluido si aplica): " + valorFinal);

        if (agregarPedido(pedido)){
            System.out.println("Pedido creado correctamente.");
        } else {
            System.out.println("Código de pedido ya existente.");
        }
    }
}
