package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class InteraccionDTO {
    private Tipo_Interaccion tipoInteraccion;
    private int Interaccion_id;
    private String Descripcion;
    private LocalDate Fecha_pub;
    private Usuario usuario;


    public Tipo_Interaccion getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(Tipo_Interaccion tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }

    public LocalDate getFecha_pub() {
        return Fecha_pub;
    }

    public void setFecha_pub(LocalDate fecha_pub) {
        Fecha_pub = fecha_pub;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getInteraccion_id() {
        return Interaccion_id;
    }

    public void setInteraccion_id(int interaccion_id) {
        Interaccion_id = interaccion_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
