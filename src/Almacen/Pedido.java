package Almacen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private List<Producto> productosSolicitados;
    private String estado;
    private Date fechaYHora;

    // Constructor
    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.productosSolicitados = new ArrayList<>();
        this.estado = "pendiente";
        this.fechaYHora = new Date();
    }

    // Getters
    public int getIdPedido() {
        return idPedido;
    }

    public List<Producto> getProductosSolicitados() {
        return productosSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    // Métodos
    public void agregarProducto(Producto producto) {
        this.productosSolicitados.add(producto);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
