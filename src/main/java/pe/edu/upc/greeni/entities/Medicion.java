package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Medicion")

public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicion;

    @Column(name = "Humedad",length =25 ,nullable = false)
    private String Humedad;

    @Column(name = "Temperatura",length =10 ,nullable = false)
    private String Temperatura;

    @Column(name = "Ph",length =19 ,nullable = false)
    private String Ph;

    @Column(name = "fecha_med",nullable = false)
    private LocalDate fecha_med;

    @ManyToOne
    @JoinColumn(name="idPlanta")
    private Planta planta;

    public Medicion() {
    }

    public Medicion(int idMedicion, String humedad, String temperatura , String ph, LocalDate fechaMed, Planta planta) {
        this.idMedicion = idMedicion;
        this.Humedad = humedad;
        this.Temperatura = temperatura;
        this.Ph = ph;
        this.fecha_med = fecha_med;
        this.planta = planta;
    }

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
        Humedad = humedad;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        Temperatura = temperatura;
    }


    public String getPh() {
        return Ph;
    }

    public void setPh(String ph) {
        Ph = ph;
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