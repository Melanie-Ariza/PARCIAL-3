import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Sabor & Tradición", 123, "Armenia, Quindío");

        Cliente cliente1 = new Cliente(456, "Ana", "23456", "ana@gmail.com", "Calle 48");
        Cliente cliente2 = new Cliente(789, "Juan", "34575", "juan@gmail.com", "Carrera 19");

        Producto plato1 = new PlatoFuerte(001, "Carne Asada", "Corte de res jugoso asado al carbón con yuca y hogao", 25000, 25, 450, true, TipoPreparacion.ASADO);
        Producto plato2 = new PlatoFuerte(002, "Pechuga Horneada a las Finas Hierbas", "Pechuga jugosa al horno acompañada de puré de papa", 22000, 30, 350, true, TipoPreparacion.HORNEADO);

        Producto bebida1 = new Bebida(003, "Limonada de Hierbabuena", "Limonada refrescante natural frappé a base de hierbabuena", 6000, 5, 400, 5, false, TipoBebida.FRIA);
        Producto bebida2 = new Bebida(004, "Chocolate con Queso", "Chocolate espeso artesanal preparado en leche", 8000, 8, 300, 65, true, TipoBebida.CALIENTE);

        Producto postre1 = new Postre(005, "Torta Tres Leches", "Ponqué esponjoso bañado en mezcla de tres leches", 8000, 10, 200, 4, true);
        Producto postre2 = new Postre(006, "Brevas con Arequipe", "Brevas en almíbar acompañadas de arequipe tradicional", 7000, 5, 150, 22, false);

        restaurante.agregarCliente(cliente1);
        restaurante.agregarCliente(cliente2);
        restaurante.agregarProducto(plato1);
        restaurante.agregarProducto(plato2);
        restaurante.agregarProducto(bebida1);
        restaurante.agregarProducto(bebida2);
        restaurante.agregarProducto(postre1);
        restaurante.agregarProducto(postre2);
        int opcion;
        do {
            System.out.println("======= SABOR & TRADICIÓN =======");
            System.out.println("1. Registrar producto.");
            System.out.println("2. Registrar cliente.");
            System.out.println("3. Calcular precio de producto.");
            System.out.println("4. Verificar condiciones de calidad de producto.");
            System.out.println("5. Consultar productos.");
            System.out.println("6. Empezar pedido.");
            System.out.println("7. Actualizar y consultar estado de pedido.");
            System.out.println("8. Consultar pedidos por cliente");
            System.out.println("9. Reporte de ventas del restaurante.");
            System.out.println("0. Salir.");
            System.out.print("Seleccione la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("------- Registrar producto -------\n");

                    System.out.println("Seleccione categoría de producto:\n" +
                            "1. Plato fuerte, 2. Bebida, 3. Postre");
                    int opcionCategoria= sc.nextInt();

                    System.out.print("Código: ");
                    int codigo= sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre= sc.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion= sc.nextLine();

                    System.out.print("Precio base: ");
                    double precioBase= sc.nextDouble();

                    System.out.print("Tiempo de preparacion: ");
                    double tiempoPreparacion= sc.nextDouble();

                    if (opcionCategoria==1){
                        System.out.print("Peso: ");
                        double peso= sc.nextDouble();

                        System.out.print("Control coccion(true/false): ");
                        boolean controlCoccion= sc.nextBoolean();

                        System.out.println("Tipo preparación: 1. Asado, 2. Frito, 3. Horneado, 4. Plancha");
                        int eleccion= sc.nextInt();

                        TipoPreparacion tipoPreparacion= TipoPreparacion.ASADO;
                        if (eleccion==2){
                            tipoPreparacion= TipoPreparacion.FRITO;
                        } else if (eleccion==3) {
                            tipoPreparacion= TipoPreparacion.HORNEADO;
                        } else if (eleccion==4) {
                            tipoPreparacion= TipoPreparacion.PLANCHA;
                        } else {
                            System.out.println("Opción no válida");
                        }
                        Producto platoFuerte= new PlatoFuerte(codigo, nombre, descripcion, precioBase, tiempoPreparacion, peso, controlCoccion, tipoPreparacion);
                        if (restaurante.agregarProducto(platoFuerte)){
                            System.out.println("Plato fuerte agregado correctamente.");
                        }else {
                            System.out.println("Código de producto repetido.");
                        }
                    } else if (opcionCategoria==2) {
                        System.out.print("Volumen: ");
                        double volumen= sc.nextDouble();

                        System.out.print("Temperatura seervicio: ");
                        double temperaturaServicio= sc.nextDouble();

                        System.out.print("¿Es especial?(true/false): ");
                        boolean esEspecial= sc.nextBoolean();

                        System.out.println("Tipo bebida: 1. Fria, 2. Caliente");
                        int eleccion= sc.nextInt();
                        TipoBebida tipoBebida= TipoBebida.FRIA;
                        if (eleccion==2){
                            tipoBebida= TipoBebida.CALIENTE;
                        }else {
                            System.out.println("Opción no valida.");
                        }

                        Producto bebida= new Bebida(codigo, nombre, descripcion, precioBase, tiempoPreparacion, volumen, temperaturaServicio, esEspecial, tipoBebida);

                        if (restaurante.agregarProducto(bebida)){
                            System.out.println("Bebida agregada correctamente.");
                        }else{
                            System.out.println("Código de producto repetido.");
                        }
                    } else if (opcionCategoria==3) {
                        System.out.print("Peso: ");
                        double peso= sc.nextDouble();

                        System.out.print("Temperatura de almacenamiento: ");
                        int temperaturaAlmacenamiento= sc.nextInt();

                        System.out.print("¿Necesita refrigerarse?(true/false): ");
                        boolean esRefrigerado= sc.nextBoolean();

                        Producto postre= new Postre(codigo, nombre, descripcion, precioBase, tiempoPreparacion, peso, temperaturaAlmacenamiento, esRefrigerado);
                        if (restaurante.agregarProducto(postre)){
                            System.out.println("Postre agregado correctamente.");
                        }else {
                            System.out.println("Código de producto repetido.");
                        }
                    }else {
                        System.out.println("Opción no valida.");
                    }
                    break;
                case 2:
                    System.out.println("------- Registrar cliente -------\n");

                    System.out.print("Documento: ");
                    int documento= sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    nombre= sc.nextLine();

                    System.out.print("Telefono: ");
                    String telefono= sc.nextLine();

                    System.out.println("Correo: ");
                    String correo= sc.nextLine();

                    System.out.println("Direccion: ");
                    String direccion= sc.nextLine();

                    Cliente cliente= new Cliente(documento, nombre, telefono, correo, direccion);

                    if (restaurante.agregarCliente(cliente)){
                        System.out.println("Cliente agregado correctamente.");
                    }else {
                        System.out.println("Documento de cliente repetido.");
                    }
                    break;
                case 3:
                    System.out.println("------- Calcular precio de producto -------\n");

                    for (Producto producto: restaurante.getListaProductos()){
                        System.out.println(producto);
                    }
                    System.out.print("Ingrese código de producto: ");
                    codigo= sc.nextInt();
                    Producto producto= restaurante.mostrarProducto(codigo);

                    double precioVenta=producto.calcularValorFinal(producto);
                    System.out.println("El precio de venta del producto es de: "+ precioVenta);
                    break;
                case 4:
                    System.out.println("------- Verificar condiciones de calidad de producto -------\n");

                    for (Producto producto0: restaurante.getListaProductos()){
                        System.out.println(producto0);
                    }
                    System.out.print("Ingrese código de producto: ");
                    codigo= sc.nextInt();
                    producto= restaurante.mostrarProducto(codigo);

                    boolean pasoCondiciones= false;
                    if (producto instanceof PlatoFuerte){
                        pasoCondiciones= ((PlatoFuerte) producto).verificarCalidadPlatoFuerte(((PlatoFuerte) producto).getPeso(), producto.getTiempoPreparacion(), ((PlatoFuerte) producto).getControlCoccion());
                    } else if (producto instanceof Bebida) {
                        pasoCondiciones= ((Bebida) producto).verificarCalidadBebida(((Bebida) producto).tipoBebida, ((Bebida) producto).getVolumen(), ((Bebida) producto).getTemperaturaServicio());

                    } else if (producto instanceof Postre){
                        pasoCondiciones= ((Postre) producto).verificarCalidadPostre(((Postre) producto).getPeso(), ((Postre) producto).getTemperaturaAlmacenamiento());
                    }

                    if (pasoCondiciones){
                        System.out.println("El producto pasó las condiciones de calidad.");
                    }else{
                        System.out.println("El producto no pasó las condiciones de calidad.");
                    }
                    break;
                case 5:
                    System.out.println("------- Consultar productos -------\n");

                    for (Producto producto0: restaurante.getListaProductos()){
                        precioVenta= producto0.calcularValorFinal(producto0);
                        System.out.println(producto0 + ", Precio venta: "+precioVenta);
                    }
                    break;
                case 6:
                    System.out.println("------- Empezar pedido -------\n");

                    System.out.print("Ingrese el documento del cliente: ");
                    documento= sc.nextInt();
                    cliente= restaurante.mostrarCliente(documento);

                    if (cliente!=null){
                        restaurante.comenzarPedido(cliente);
                    }else {
                        System.out.println("Cliente no encontrado. Debe registrarse antes de comprar.");
                    }
                    break;
                case 7:
                    System.out.println("------- Actualizar y consultar estado de pedido -------\n");

                    System.out.print("Ingrese el código del pedido: ");
                    codigo= sc.nextInt();

                    for (Pedido pedido: restaurante.getListaPedidos()){
                        if (pedido.getCodigo()== codigo){
                            Pedido pedido0= restaurante.mostrarPedido(codigo);
                            System.out.println(pedido0);

                            System.out.print("¿Desea actualizar el estado del pedido?(1. Sí / 2. No): ");
                            int decision= sc.nextInt();

                            if (decision==1){
                                System.out.println("1. Pendiente\n2. Confirmado\n3. Entregado\n4. Cancelado");
                                System.out.print("Seleccione el nuevo estado de pedido: ");
                                int opcionEstado= sc.nextInt();

                                if (opcionEstado>=1 && opcionEstado<=4){
                                    boolean estadoActualizado= restaurante.actualizarEstadoPedido(pedido, opcionEstado);
                                    if (estadoActualizado){
                                        System.out.println("Estado de pedido actualizado correctamente.");
                                    }else {
                                        System.out.println("El estado del pedido no se pudo actualizar.");
                                    }
                                }else {
                                    System.out.println("Opción no valida.");
                                }

                            }else {
                                System.out.println("Hecho");
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("------- Consultar pedidos por cliente -------\n");

                    System.out.print("Ingrese el documento del cliente: ");
                    documento= sc.nextInt();

                    for (Cliente cliente0: restaurante.getListaClientes()){
                        if (cliente0.getDocumento()==documento){
                            for (Pedido pedido: restaurante.getListaPedidos()){
                                System.out.println(pedido);
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("------- Reporte de ventas del restaurante -------");

                    System.out.println("1. Ingresos totales del restaurante.");
                    System.out.println("2. Producto con mayor cantidad de unidades vendidas.");
                    System.out.println("3. Categoría con mayor cantidad de ingresos.");
                    System.out.println("Ingrese la opción que desea visualizar: ");
                    int opcionReporte= sc.nextInt();

                    if (opcionReporte==1){
                        double ingresosTotales= restaurante.calcularIngresosTotales();
                        System.out.println("Los ingresos totales del restaurante son: "+ ingresosTotales);
                    } else if (opcionReporte==2) {
                        String productoMasVendido= restaurante.obtenerProductoMasVendido();
                        System.out.println(productoMasVendido);
                    } else if (opcionReporte==3) {
                        String categoriaMayorIngresos= restaurante.determinarCategoriaMayorIngresos();
                        System.out.println(categoriaMayorIngresos);
                    }else {
                        System.out.println("Opción no valida.");
                    }
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (opcion != 0);
    }
}