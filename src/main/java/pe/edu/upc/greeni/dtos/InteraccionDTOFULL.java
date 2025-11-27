package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class InteraccionDTOFULL {
    private int interaccion_id;
    private String descripcion;
    private LocalDate fecha_pub;
    private Usuario usuario;
    private Tipo_Interaccion tipoInteraccion;



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_pub() {
        return fecha_pub;
    }

    public void setFecha_pub(LocalDate fecha_pub) {
        this.fecha_pub = fecha_pub;
    }

    public int getInteraccion_id() {
        return interaccion_id;
    }

    public void setInteraccion_id(int interaccion_id) {
        this.interaccion_id = interaccion_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo_Interaccion getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(Tipo_Interaccion tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }
}

