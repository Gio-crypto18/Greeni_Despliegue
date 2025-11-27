package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Diagnostico;
import pe.edu.upc.greeni.entities.Especie;
import pe.edu.upc.greeni.entities.Usuario;

import java.time.LocalDate;

public class PLANTADTOFULLDTO {
    private int idPlanta;
    private String nombrePlanta;
    private Boolean imagen;
    private LocalDate fecha_reg;
    private Especie especie;
    private Usuario usuario;
    private Diagnostico diagnostico;

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public Boolean getImagen() {
        return imagen;
    }

    public void setImagen(Boolean imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(LocalDate fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
