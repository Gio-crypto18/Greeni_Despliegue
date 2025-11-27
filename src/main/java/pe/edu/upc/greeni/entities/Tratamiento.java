package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTratamiento;

    @Column(name="nombre", length = 50, nullable = false)
    private String  nombre;

    @Column(name="duracion", nullable = false)
    private int duracion;

    @Column(name="fechainicio",  nullable = false)
    private LocalDate fechainicio;

    @Column(name="fechafin",  nullable = false)
    private LocalDate fechafin;

    @ManyToOne
    @JoinColumn(name="idDiagnostico")
    private Diagnostico diagnostico;

    public Tratamiento(int idTratamiento, String nombre, int duracion, LocalDate fechainicio, LocalDate fechafin, Diagnostico diagnostico) {
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.duracion = duracion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.diagnostico = diagnostico;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDate fechafin) {
        this.fechafin = fechafin;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Tratamiento() {
    }
}
