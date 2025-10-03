package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.EstadoRecordatorio;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class RecordatorioDTO {
    private int idRecordatorio;
    private String nombre;
    private LocalDate fechaRe;
    private String tipo;
    private Usuario usuario;
    private EstadoRecordatorio estado;

    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaRe() {
        return fechaRe;
    }

    public void setFechaRe(LocalDate fechaRe) {
        this.fechaRe = fechaRe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoRecordatorio getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecordatorio estado) {
        this.estado = estado;
    }
}
