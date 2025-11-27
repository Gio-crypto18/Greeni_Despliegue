package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class InteraccionDTO {
    private int interaccion_id;
    private String descripcion;
    private LocalDate fecha_pub;
    private Usuario id;
    private Tipo_Interaccion tipoInteraccion_Id;

    public int getInteraccion_id() {
        return interaccion_id;
    }

    public void setInteraccion_id(int interaccion_id) {
        this.interaccion_id = interaccion_id;
    }

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

    public Usuario getId() {
        return id;
    }

    public void setId(Usuario id) {
        this.id = id;
    }

    public Tipo_Interaccion getTipoInteraccion_Id() {
        return tipoInteraccion_Id;
    }

    public void setTipoInteraccion_Id(Tipo_Interaccion tipoInteraccion_Id) {
        this.tipoInteraccion_Id = tipoInteraccion_Id;
    }
}


