package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Planta;

import java.time.LocalDate;

public class MedicionDTOInsert {
    private int idMedicion;
    private String Humedad;
    private String Temperatura;
    private String Ph;
    private LocalDate fecha_med;
    private Planta planta;

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public String getHumedad() {
        return Humedad;
    }

    public void setHumedad(String humedad) {
        this.Humedad = humedad;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.Temperatura = temperatura;
    }

    public String getPh() {
        return Ph;
    }

    public void setPh(String ph) {
        this.Ph = ph;
    }


    public LocalDate getFecha_med() {
        return fecha_med;
    }

    public void setFecha_med(LocalDate fecha_med) {
        this.fecha_med = fecha_med;
    }


    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
