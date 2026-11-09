import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int documento;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private List<Pedido> pedidos;

    //Constructor
    public Cliente(int documento, String nombre, String telefono, String correo, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.pedidos = new ArrayList<>();
    }

    //Get Set


    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getDocumento() {return documento;}

    public void setDocumento(int documento) {this.documento = documento;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    @Override
    public String toString() {
        return
                "Documento: " + documento +
                ", Nombre: " + nombre +
                ", Teléfono: " + telefono +
                ", Correo: " + correo +
                ", Dirección: " + direccion+
                ", Pedidos: " + pedidos;
    }
}