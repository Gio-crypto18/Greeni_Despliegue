package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class InteraccionDTOList {

    private int interaccion_id;
    private String Descripcion;
    private LocalDate Fecha_pub;
    private UsuarioNombreDTO usuario;
    private Tipo_Interaccion tipointeraccion;


    public int getInteraccion_id() {
        return interaccion_id;
    }

    public Tipo_Interaccion getTipointeraccion() {
        return tipointeraccion;
    }

    public void setTipointeraccion(Tipo_Interaccion tipointeraccion) {
        this.tipointeraccion = tipointeraccion;
    }

    public void setInteraccion_id(int interaccion_id) {
        this.interaccion_id = interaccion_id;
    }

    public String getDescripcion() {
        return Descripcion;
    }


    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public UsuarioNombreDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioNombreDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha_pub() {
        return Fecha_pub;
    }

    public void setFecha_pub(LocalDate fecha_pub) {
        Fecha_pub = fecha_pub;
    }
}
