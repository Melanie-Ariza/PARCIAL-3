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
