

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import Almacen.Informe;
import Almacen.Pedido;
import Almacen.Producto;
import Almacen.Usuario;
import Almacen.UsuarioManager;

public class Main {
    private static UsuarioManager usuarioManager = new UsuarioManager();
    private static List<Producto> productos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Informe informe = new Informe();
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogueado;

    public static void main(String[] args) {
        while (true) {
            if (usuarioLogueado == null) {
                mostrarMenuLogin();
            } else {
                mostrarMenuPrincipal();
            }
        }
    }

    private static void mostrarMenuLogin() {
        System.out.println("=== Login ===");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        usuarioLogueado = usuarioManager.authenticate(username, password);
        if (usuarioLogueado == null) {
            System.out.println("Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Administrar Productos");
        System.out.println("2. Gestionar Pedidos");
        System.out.println("3. Generar Informes");
        System.out.println("4. Administrar Usuarios");
        System.out.println("5. Salir");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                if (usuarioLogueado.getRol().equals("Administrador")) {
                    administrarProductos();
                } else {
                    System.out.println("Acceso denegado.");
                }
                break;
            case 2:
                gestionarPedidos();
                break;
            case 3:
                if (usuarioLogueado.getRol().equals("Administrador") || usuarioLogueado.getRol().equals("Contador")) {
                    generarInformes();
                } else {
                    System.out.println("Acceso denegado.");
                }
                break;
            case 4:
                if (usuarioLogueado.getRol().equals("Administrador")) {
                    administrarUsuarios();
                } else {
                    System.out.println("Acceso denegado.");
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void administrarProductos() {
        System.out.println("=== Administrar Productos ===");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Modificar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Volver al Menú Principal");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                agregarProducto();
                break;
            case 2:
                modificarProducto();
                break;
            case 3:
                eliminarProducto();
                break;
            case 4:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void agregarProducto() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Cantidad en stock: ");
        int cantidadEnStock = Integer.parseInt(scanner.nextLine());

        productos.add(new Producto(id, nombre, descripcion, precio, cantidadEnStock));
        System.out.println("Producto agregado.");
    }

    private static void modificarProducto() {
        System.out.print("ID del producto a modificar: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                System.out.print("Nuevo nombre (deje en blanco para no cambiar): ");
                String nombre = scanner.nextLine();
                if (!nombre.isEmpty()) {
                    producto.setNombre(nombre);
                }
                System.out.print("Nueva descripción (deje en blanco para no cambiar): ");
                String descripcion = scanner.nextLine();
                if (!descripcion.isEmpty()) {
                    producto.setDescripcion(descripcion);
                }
                System.out.print("Nuevo precio (deje en blanco para no cambiar): ");
                String precioStr = scanner.nextLine();
                if (!precioStr.isEmpty()) {
                    producto.setPrecio(Double.parseDouble(precioStr));
                }
                System.out.print("Nueva cantidad en stock (deje en blanco para no cambiar): ");
                String cantidadStr = scanner.nextLine();
                if (!cantidadStr.isEmpty()) {
                    producto.setCantidadEnStock(Integer.parseInt(cantidadStr));
                }
                System.out.println("Producto modificado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        productos.removeIf(producto -> producto.getId() == id);
        System.out.println("Producto eliminado.");
    }

    private static void gestionarPedidos() {
        System.out.println("=== Gestionar Pedidos ===");
        System.out.println("1. Crear Pedido");
        System.out.println("2. Cambiar Estado de Pedido");
        System.out.println("3. Volver al Menú Principal");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                crearPedido();
                break;
            case 2:
                cambiarEstadoPedido();
                break;
            case 3:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crearPedido() {
        System.out.print("ID del Pedido: ");
        int idPedido = Integer.parseInt(scanner.nextLine());
        Pedido pedido = new Pedido(idPedido);

        while (true) {
            System.out.print("ID del Producto a agregar (0 para finalizar): ");
            int idProducto = Integer.parseInt(scanner.nextLine());
            if (idProducto == 0) break;

            for (Producto producto : productos) {
                if (producto.getId() == idProducto) {
                    pedido.agregarProducto(producto);
                    System.out.println("Producto agregado al pedido.");
                    break;
                }
            }
        }

        pedidos.add(pedido);
        System.out.println("Pedido creado.");
    }

    private static void cambiarEstadoPedido() {
        System.out.print("ID del Pedido: ");
        int idPedido = Integer.parseInt(scanner.nextLine());

        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                System.out.print("Nuevo estado (pendiente, enviado, entregado): ");
                String nuevoEstado = scanner.nextLine();
                pedido.cambiarEstado(nuevoEstado);
                System.out.println("Estado del pedido cambiado a " + nuevoEstado);
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }

    private static void generarInformes() {
        System.out.println("=== Generar Informes ===");
        System.out.println("1. Informe de Pedidos");
        System.out.println("2. Informe de Inventario");
        System.out.println("3. Volver al Menú Principal");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                informe.generarInformePedidos(pedidos);
                break;
            case 2:
                informe.generarInformeInventario(productos);
                break;
            case 3:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void administrarUsuarios() {
        System.out.println("=== Administrar Usuarios ===");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Volver al Menú Principal");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                agregarUsuario();
                break;
            case 2:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void agregarUsuario() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Rol: ");
        String rol = scanner.nextLine();

        usuarioManager.addUser(username, password, rol);
        System.out.println("Usuario agregado.");
    }
}
