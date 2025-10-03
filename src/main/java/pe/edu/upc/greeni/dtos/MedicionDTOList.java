package pe.edu.upc.greeni.dtos;

import java.time.LocalDate;

public class MedicionDTOList {
    private String Humedad;
    private String Temperatura;
    private String Ph;
    private LocalDate fecha_med;


    public String getHumedad() {
        return Humedad;
    }

    public void setHumedad(String humedad) {
        Humedad = humedad;
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
}
