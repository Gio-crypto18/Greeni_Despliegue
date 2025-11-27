package pe.edu.upc.greeni.dtos;

import java.time.LocalDate;

public class DiagnosticoDTO {
    private int idDiagnostico;
    private int severidad;
    private String acciones;
    private LocalDate fechadia;


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
}
