package Almacen;
import java.util.ArrayList;
import java.util.List;

// Producto

public class Producto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer cantInStock;

    private int nextId;

    private List<Producto> productos;

    public void Almacen() {
        this.productos = new ArrayList<>();
        this.nextId = 1; // Inicializar el ID en 1

    }

    
    public void agregarProducto(String nombre, String descripcion, Integer precio, Integer cantInStock) {
        Producto producto = new Producto();
        producto.setId(nextId); 
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantInStock(cantInStock);
        productos.add(producto);
        nextId++; // Incrementar el ID para el próximo producto
    }


    public boolean modificarProducto(Integer id, Producto productoModificado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productoModificado.setId(id); // Asegurar que el ID no cambie
                productos.set(i, productoModificado);
                return true;
            }
        }
        return false;
    }

    
    public boolean eliminarProducto(Integer id) {
        return productos.removeIf(producto -> producto.getId().equals(id));
    }

    
    public List<Producto> verProductos() {
        return new ArrayList<>(productos);
    }
    
    
    // Geters and Seters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Integer getCantInStock() {
        return cantInStock;
    }
    public void setCantInStock(Integer cantInStock) {
        this.cantInStock = cantInStock;
    }


}