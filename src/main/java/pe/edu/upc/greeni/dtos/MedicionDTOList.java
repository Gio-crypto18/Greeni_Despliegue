package pe.edu.upc.greeni.dtos;

import java.time.LocalDate;

public class MedicionDTOList {
    private String humedad;
    private String temperatura;
    private String ph;
    private LocalDate fecha_med;


    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public LocalDate getFecha_med() {
        return fecha_med;
    }

    public void setFecha_med(LocalDate fecha_med) {
        this.fecha_med = fecha_med;
    }
}
