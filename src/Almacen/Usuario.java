package Almacen;

public class Usuario {
    private String username;
    private String password;
    private String rol;

    // Constructor
    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Verificar contraseña
    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }
}
