package Almacen;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private List<Usuario> usuarios;

    // Constructor
    public UsuarioManager() {
        this.usuarios = new ArrayList<>();
        // Añadir usuarios preestablecidos
        usuarios.add(new Usuario("admin", "admin123", "Administrador"));
        usuarios.add(new Usuario("almacenero", "almacenero123", "Almacenero"));
        usuarios.add(new Usuario("contador", "contador123", "Contador"));
    }

    // Añadir un nuevo usuario
    public void addUser(String username, String password, String rol) {
        usuarios.add(new Usuario(username, password, rol));
    }

    // Verificar usuario y contraseña
    public Usuario authenticate(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.verificarPassword(password)) {
                return usuario;
            }
        }
        return null;
    }
}
