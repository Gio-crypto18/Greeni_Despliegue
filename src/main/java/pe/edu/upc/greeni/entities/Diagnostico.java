package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @Column(name="severidad", nullable = false)
    private int severidad;

    @Column(name="acciones", length = 100, nullable = false)
    private String acciones;

    @Column(name="fecha_dia", length = 100, nullable = false)
    private LocalDate fechadia;






    public Diagnostico(int idDiagnostico, int severidad, String acciones, LocalDate fechadia) {
        this.idDiagnostico = idDiagnostico;
        this.severidad = severidad;
        this.acciones = acciones;
        this.fechadia = fechadia;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getSeveridad() {
        return severidad;
    }

    public void setSeveridad(int severidad) {
        this.severidad = severidad;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public LocalDate getFechadia() {
        return fechadia;
    }

    public void setFechadia(LocalDate fechadia) {
        this.fechadia = fechadia;
    }

    public Diagnostico() {

    }

}
