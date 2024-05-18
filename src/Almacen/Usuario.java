package Almacen;

import java.util.HashMap;
import java.util.Map;

// Class to manage users and their roles
public class Usuario {
    // Attributes for user, password and role
    private String user;
    private String pass;
    private String rol;
    // Map to store users
    private Map<String, Usuario> users = new HashMap<>();

    // Constructor for Usuario class
    public Usuario(String user, String pass, String rol) {
        this.user = user;
        this.pass = pass;
        this.rol = rol;
    }

    // Method to add a new user
    public void addUser(String user, String pass, String rol) {
        users.put(user, new Usuario(user, pass, rol));
    }

    public void setRole(String user, String rol) {
        if (users.containsKey(user)) {
            users.get(user).rol = rol;
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public boolean authenticate(String user, String pass) {
        if (users.containsKey(user)) {
            Usuario usuario = users.get(user);
            return usuario.pass.equals(pass);
        }
        return false;
    }

    public static void main(String[] args) {
        // Create an instance of Usuario class
        Usuario usuarios = new Usuario();
        // Add two users
        usuarios.addUser("usuario1", "contraseña1", "admin");
        usuarios.addUser("usuario2", "contraseña2", "user");

        // Set roles for users
        usuarios.setRole("usuario1", "admin");
        usuarios.setRole("usuario2", "user");

        // Authenticate a user
        if (usuarios.authenticate("usuario1", "contraseña1")) {
            System.out.println("Acceso permitido para el administrador.");
        } else {
            System.out.println("No se ha podido autenticar al usuario o la contraseña es incorrecta.");
        }
    }
}