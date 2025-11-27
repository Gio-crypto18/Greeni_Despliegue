package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Planta;

import java.time.LocalDate;

public class MedicionfullDTO {
    private int idMedicion;
    private String humedad;
    private String temperatura;
    private String ph;
    private LocalDate fecha_med;
    private Planta planta;

    public int getIdMedicion() { return idMedicion; }
    public void setIdMedicion(int idMedicion) { this.idMedicion = idMedicion; }

    public String getHumedad() { return humedad; }
    public void setHumedad(String humedad) { this.humedad = humedad; }

    public String getTemperatura() { return temperatura; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }

    public String getPh() { return ph; }
    public void setPh(String ph) { this.ph = ph; }

    public LocalDate getFecha_med() { return fecha_med; }
    public void setFecha_med(LocalDate fecha_med) { this.fecha_med = fecha_med; }

    public Planta getPlanta() { return planta; }
    public void setPlanta(Planta planta) { this.planta = planta; }
}
