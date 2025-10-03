package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Planta;

import java.time.LocalDate;

public class MedicionReporteListDTO {
    private int idMedicion;
    private String Temperatura;
    private LocalDate fecha_med;

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        Temperatura = temperatura;
    }

    public LocalDate getFecha_med() {
        return fecha_med;
    }

    public void setFecha_med(LocalDate fecha_med) {
        this.fecha_med = fecha_med;
    }
}
