package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Planta")
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanta;

    @Column(name = "nombrePlanta", length = 25, nullable = false)
    private String nombrePlanta;

    @Column(name = "Imagen", nullable = false)
    private Boolean imagen;

    @Column(name = "fecha_reg", nullable = false)
    private LocalDate fecha_reg;

    @ManyToOne
    @JoinColumn(name="idEspecie", nullable = false)
    private Especie especie;

    @ManyToOne
    @JoinColumn(name="idUsuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="idDiagnostico")
    private Diagnostico diagnostico;




    public Planta() {
    }

    public Planta(int idPlanta, String nombrePlanta, Boolean imagen, LocalDate fecha_reg, Especie especie, Usuario usuario, Diagnostico diagnostico) {
        this.idPlanta = idPlanta;
        this.nombrePlanta = nombrePlanta;
        this.imagen = imagen;
        this.fecha_reg = fecha_reg;
        this.especie = especie;
        this.usuario = usuario;
        this.diagnostico = diagnostico;
    }

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

