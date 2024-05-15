package Almacen;

import java.util.Scanner;

public class Pedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Almacenero almacenero = new Almacenero();
        if (almacenero.autenticarAlmacenero(scanner)) {
            almacenero.mostrarSubMenu(scanner);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        scanner.close();
    }
}

class Almacenero {
    private final String[] usernames = {"almacenero"};
    private final String[] passwords = {"almacenero123"};

    public boolean autenticarAlmacenero(Scanner scanner) {
        System.out.println("Ingrese su nombre de usuario:");
        String userName = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();

        for (int i = 0; i < usernames.length; i++) {
            if (userName.equals(usernames[i]) && password.equals(passwords[i])) {
                return true;
            }
        }
        return false;
    }

    public void mostrarSubMenu(Scanner scanner) {
        System.out.println("\nBienvenido al menú de opciones de Almacenero!");
        System.out.println("Elija una opción del menú:");
        System.out.println("1. Ver inventario de productos");
        System.out.println("2. Gestionar pedidos");
        System.out.println("3. Confirmar envíos");

        try {
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Mostrar inventario...");
                    break;
                case 2:
                    System.out.println("Gestionar pedidos...");
                    break;
                case 3:
                    System.out.println("Confirmar envíos...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: entrada no válida.");
        }
    }
}
 