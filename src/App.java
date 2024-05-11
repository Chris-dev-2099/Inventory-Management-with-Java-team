import java.util.Scanner;


// Hay errores por aun faltan crear las funciones para cada opcion


public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienbenido al sistema del Almacen de Distribucion!!\n" );
        System.out.println("Con que rol desea ingresar al Almacen");
        System.out.println("1. Administrador");
        System.out.println("2. Almacenero");
        System.out.println("3. Contador");

        Scanner rolScan = new Scanner(System.in);
        Integer rol = rolScan.nextInt();

        switch (rol) {
            case 1:
                System.out.println("Bienvenido usuario Administrador!");
                System.out.println("Ingrese su usuario: ");
                Scanner user = new Scanner(System.in);
                String userName = user.nextLine();
                
                System.out.println("Ingrese su contraseña: ");
                Scanner pass = new Scanner(System.in);
                String password = pass.nextLine();
                    

                if (userName == "array de usuarios.username" && password == "array de usuarios.password") {
                    
                    // Sub menu para Administrator

                    System.out.println("Bienbenido al menu de opciones de Administrador!\n" );
                    System.out.println("Elija una opccion del menu: ");

                    System.out.println("Productos:");
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Modificar producto");
                    System.out.println("3. Eliminar producto\n");

                    System.out.println("Envios y pedidos:");
                    System.out.println("4.Gestionar pedidos");
                    System.out.println("5.Confirmar envios\n");


                    System.out.println("Ventas eh Inventario:");
                    System.out.println("4.Generar informes de ventas");
                    System.out.println("5.generar informes de inventario\n");


                    System.out.println("Usuarios:");
                    System.out.println("Administrar usuarios");
                    System.out.println("Asignar roles a usuarios\n");

                    // Puede agregar, modificar y eliminar productos.
                    // Puede gestionar pedidos y confirmar envíos.
                    // Puede generar informes de ventas y de inventario.
                    // Puede administrar usuarios y asignar roles.

                    do {
                        // falta crear las opciones del submenu con dowhile
                    } while (condition);

                }else{
                    System.out.println("Su usuario o contraseña es incorrecto, intentelo de nuevo por favor");
                }

                
                break;
            case 2:
                System.out.println("Bienvenido usuario Almacenero!");
                System.out.println("Ingrese su usuario:");
                Scanner user2 = new Scanner(System.in);
                String userName2 = user2.nextLine();

                System.out.println("Ingrese su contraseña: ");
                Scanner pass2 = new Scanner(System.in);
                String password2 = pass2.nextLine();

                if (userName2 == "array de usuarios.username" && password2 == "array de usuarios.password") {
                    // Sub menu para Almacenero
                    System.out.println("Bienbenido al menu de opciones de Almacenero!\n" );
                    System.out.println("Elija una opccion del menu: ");
                    System.out.println("1. Ver inventario de productos");
                    System.out.println("2. Gestionar pedidos");
                    System.out.println("3. Confirmar envios");

                    // Puede ver el inventario de productos.
                    // Puede gestionar pedidos y confirmar envíos.

                    do {
                        // falta crear las opciones del submenu con dowhile
                    } while (condition);
                    
                }else{
                    System.out.println("Su usuario o contraseña es incorrecto, intentelo de nuevo por favor");
                }

                
                break;
        
            case 3:
                System.out.println("Bienvenido usuario Contador!");
                System.out.print("Ingrese su usuario: ");
                Scanner user3 = new Scanner(System.in);
                String userName3 = user3.nextLine();

                System.out.println("Ingrese su contraseña: ");
                Scanner pass3 = new Scanner(System.in);
                String password3 = pass3.nextLine();

                if (userName3 == "array de usuarios.username" && password3 == "array de usuarios.password") {
                    
                    // Sub menu para Contador
                    System.out.println("Bienbenido al menu de opciones de Contador!\n" );
                    System.out.println("Elija una opccioon del menu: ");
                    System.out.println("1. Ver inventario de productos");
                    System.out.println("2. Generar informes de inventario");

                    // Puede ver el inventario de productos.
                    // Puede generar informes de inventario.

                    do {
                        // falta crear las opciones del submenu con dowhile
                    } while (condition);
                    
                }else{
                    System.out.println("Su usuario o contraseña es incorrecto, intentelo de nuevo por favor");
                }

                break;
            default:
                System.out.println("Ingrese una opcion valida '1', '2', '3' ");
                break;
        }


    }
}
