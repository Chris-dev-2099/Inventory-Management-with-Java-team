package Almacen;

import java.util.List;

public class Informe {

    // Generar informe de pedidos
    public void generarInformePedidos(List<Pedido> pedidos) {
        System.out.println("Informe de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID Pedido: " + pedido.getIdPedido() + ", Estado: " + pedido.getEstado() + ", Fecha: " + pedido.getFechaYHora());
        }
    }

    // Generar informe de inventario
    public void generarInformeInventario(List<Producto> productos) {
        System.out.println("Informe de Inventario:");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad en Stock: " + producto.getCantidadEnStock());
        }
    }
}







// package Almacen;

// import java.util.ArrayList;
// import java.util.List;

// public class Informe {

//     private static List<Producto> productos = new ArrayList<>();
//     private static int nextId = 1;

//     public static void agregarProducto(String nombre, String descripcion, int precio, int cantInStock) {
//         Producto producto = new Producto();
//         producto.setId(nextId); 
//         producto.setNombre(nombre);
//         producto.setDescripcion(descripcion);
//         producto.setPrecio(precio);
//         producto.setCantInStock(cantInStock);
//         productos.add(producto);
//         nextId++; // Incrementar el ID para el próximo producto
//     }

//     public static void generarInformeInventario(List<Producto> productos) {
//         System.out.println("Informe de Inventario");
//         System.out.println("=====================");
//         for (Producto producto : productos) {
//             System.out.printf("Producto: %s, Descripción: %s, Cantidad Disponible: %d, Precio Unitario: %.2f%n",
//                     producto.getNombre(), producto.getDescripcion(), producto.getCantInStock(), (float) producto.getPrecio());
//         }
//     }

//     public static void verInventario() {
//         System.out.println("Inventario Actual");
//         System.out.println("=================");
//         for (Producto producto : productos) {
//             System.out.printf("ID: %d, Producto: %s, Cantidad Disponible: %d%n",
//                     producto.getId(), producto.getNombre(), producto.getCantInStock());
//         }
//     }

//     public static void main(String[] args) {
//         // Agregar productos
//         agregarProducto("Producto A", "Descripción A", 105, 100);
//         agregarProducto("Producto B", "Descripción B", 200, 200);

//         // Generar informe de inventario
//         generarInformeInventario(productos);

//         // Ver inventario actual
//         verInventario();
//     } 
// }
