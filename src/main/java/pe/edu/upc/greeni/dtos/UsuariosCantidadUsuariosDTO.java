package pe.edu.upc.greeni.dtos;

public class UsuariosCantidadUsuariosDTO {
    private String rol;
    private int cantidadUsuarios;

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuarios(int cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
